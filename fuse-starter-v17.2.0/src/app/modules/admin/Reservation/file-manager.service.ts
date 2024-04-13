import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, catchError, map, Observable, of, switchMap, take, tap, throwError } from 'rxjs';
import { Item, Items } from './file-manager.types';
import { Reservation } from './Reservation';

@Injectable({
    providedIn: 'root'
})
export class FileManagerService
{
    // Private
    private _item: BehaviorSubject<Item | null> = new BehaviorSubject(null);
    private _items: BehaviorSubject<Items | null> = new BehaviorSubject(null);
    private baseUrl = 'http://localhost:8080/ReservationBillet'; // Replace with your API base URL
    event: Observable<Item>;

    /**
     * Constructor
     */
    constructor(private _httpClient: HttpClient)
    {
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Accessors
    // -----------------------------------------------------------------------------------------------------

    /**
     * Getter for items
     */
    get items$(): Observable<Items>
    {
        return this._items.asObservable();
    }

    /**
     * Getter for item
     */
    get item$(): Observable<Item>
    {
        return this._item.asObservable();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------
    getAllReservations(){
        return this._httpClient.get<any>('http://localhost:8085/events')
      }
    getAllCommentaires(){
        return this._httpClient.get<any>('http://localhost:8081/CommentaireEvaluation/get-all-commentaires')
      }
    /**
     * Get items
     */
    getItems(folderId: string | null = null): Observable<Item[]>
    {
        return this._httpClient.get<Items>('api/apps/file-manager', {params: {folderId}}).pipe(
            tap((response: any) => {
                this._items.next(response);
            })
        );
    }

    /**
     * Get item by id
     */
    getEventById(id: number): Observable<Item> {
        this.event= this._httpClient.get<Item>(`http://localhost:8085/events/${id}`);
        return this.event;
    }

    getItemById(id: number): Observable<Item> {
        return this.getEventById(id).pipe(
            switchMap((item) => {
                // Mettre à jour l'événement
                this._item.next(item);
    
                // Renvoyer l'événement
                return of(item);
            }),
            catchError(() => {
                return throwError('Impossible de trouver l\'élément avec l\'identifiant ' + id + '!');
            })
        );
    }
    
  addReservation(reservation: Reservation): Observable<Reservation> {
    return this._httpClient.post<Reservation>(`localhost:8081/ReservationBillet/add-reservation`, reservation);
  }
}
