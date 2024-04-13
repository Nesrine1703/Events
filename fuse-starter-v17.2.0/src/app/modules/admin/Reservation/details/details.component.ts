import { ChangeDetectionStrategy, ChangeDetectorRef, Component, ElementRef, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { MatDrawerToggleResult } from '@angular/material/sidenav';
import { Observable, Subject, takeUntil } from 'rxjs';
import { FileManagerListComponent } from '../list/list.component';
import { FileManagerService } from '../file-manager.service';
import { Item } from '../file-manager.types';
import { UntypedFormBuilder, UntypedFormGroup, Validators ,FormBuilder, FormGroup} from '@angular/forms';
import { FuseConfirmationService } from '@fuse/services/confirmation';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { MatTabGroup } from '@angular/material/tabs';
import { Reservation } from '../Reservation';
import { HttpClient } from '@angular/common/http';
import { MatRadioChange } from '@angular/material/radio';
import { Commentaire } from '../Commentaire';

@Component({
    selector       : 'file-manager-details',
    templateUrl    : './details.component.html',
    encapsulation  : ViewEncapsulation.None,
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class FileManagerDetailsComponent implements OnInit, OnDestroy
{   horizontalStepperForm: UntypedFormGroup;
    StepperForm: UntypedFormGroup;
    configForm: UntypedFormGroup;
    item: Item;
    file: Event;
    public events$: Observable<any[]>;
    private _unsubscribeAll: Subject<any> = new Subject<any>();
    ticketNumbers: number[] = Array.from({length: 9}, (_, i) => i + 1);
    commentaire : Commentaire;
    /**
     * Constructor
     */
    reservationForm: FormGroup;
    commentaireForm: FormGroup

    constructor(
      private formBuilder: FormBuilder,
      private http: HttpClient,

        private _formBuilder: UntypedFormBuilder,
        private _changeDetectorRef: ChangeDetectorRef,
        private _fileManagerListComponent: FileManagerListComponent,
        private _fileManagerService: FileManagerService,
        private _fuseConfirmationService: FuseConfirmationService,
        private dialog: MatDialog,
        private router: Router,
        private elementRef: ElementRef
    )
    
    {
      this.reservationForm = this.formBuilder.group({
        // Define your form controls here
      });
      this.commentaireForm = this.formBuilder.group({
        // Define your form controls here
      });
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
      this.events$ = this._fileManagerService.getAllCommentaires();
        this.events$.subscribe(
            events => {
                console.log(events); // Afficher les événements dans la console
            },
            error => {
                console.error('Error fetching events:', error);
            }
        );
        // Horizontal stepper form
        this.horizontalStepperForm = this._formBuilder.group({
          step1: this._formBuilder.group({
              email   : ['', [Validators.required, Validators.email]],
              country : ['', Validators.required],
          }),
          step2: this._formBuilder.group({
            paymentMethod: ['', Validators.required]

          }),
          pushNotifications: ['everything', Validators.required]

      });
        


        // Open the drawer
        this._fileManagerListComponent.matDrawer.open();

        // Get the item
        this._fileManagerService.item$
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe((item: Item) => {

                // Open the drawer in case it is closed
                this._fileManagerListComponent.matDrawer.open();

                // Get the item
                this.item = item;

                // Mark for check
                this._changeDetectorRef.markForCheck();
            });
    }


    /**
     * On destroy
     */
    ngOnDestroy(): void
    {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next(null);
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Close the drawer
     */
    closeDrawer(): Promise<MatDrawerToggleResult>
    {
        return this._fileManagerListComponent.matDrawer.close();
    }

    /**
     * Track by function for ngFor loops
     *
     * @param index
     * @param item
     */
    trackByFn(index: number, item: any): any
    {
        return item.id || index;
    }
        /**
     * Open confirmation dialog
     */
  

  navigateToTab(tabGroup: MatTabGroup, tabIndex: number): void {
    tabGroup.selectedIndex = tabIndex;
    const sectionElement = this.elementRef.nativeElement.querySelector('.section-class'); // Replace '.section-class' with the class of the section containing the tab content
    if (sectionElement) {
      sectionElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }
  updatePaymentMethod(event: MatRadioChange) {
    const value = event.value;
    const isOnline = value === 'online';
    this.horizontalStepperForm.get('step2.paymentMethod').setValue(isOnline);
  }
  afficher = false;
  reservationAdded :  Reservation
  commentaireAdded :  Commentaire
  textareaValue: string = '';

  // Function to handle textarea value changes
  onTextareaChange(event: any) {
    this.textareaValue = event.target.value;
  }
  submit(){
    
      const commentaire: Commentaire = {
        idEvent: Number(this.item.id),
        datePublicationCommentaire: new Date().toISOString(),
        commentaire: this.textareaValue,
      };
    
    
    this.http.post<Commentaire>('http://localhost:8081/CommentaireEvaluation/add-commentaire', commentaire)
        .subscribe(res => {
          console.log('Reservation added:', res);
          this.commentaireAdded = res;
          // Reset the form after successful submission
          this.horizontalStepperForm.reset();
        }, error => {
          console.error('Error adding comm:', error);
        });
        
  }
  submitForm() {
    if (this.horizontalStepperForm.valid) {
      const formData = this.horizontalStepperForm.value;
      const reservation: Reservation = {
        idEvent : Number(this.item.id),
        reservationDate: new Date().toISOString(), // Example, replace with actual date
        numberOfTickets: formData.step1.country,
        isPaid: formData.step2.paymentMethod === 'online',
        email: formData.step1.email,
       
      };

      console.log("isPais",formData.step2.paymentMethod === 'online')

      this.http.post<Reservation>('http://localhost:8080/ReservationBillet/add-reservation', reservation)
        .subscribe(res => {
          console.log('Reservation added:', res);
          this.reservationAdded = res;
          // Reset the form after successful submission
          this.horizontalStepperForm.reset();
          this.afficher = true;
        }, error => {
          console.error('Error adding reservation:', error);
        });
    }
  }
  totalPrice: number;

  // Calculate total price based on number of tickets and price per ticket
  calculateTotalPrice() {
    this.totalPrice = this.reservationAdded.numberOfTickets * this.item.price;
  }
}