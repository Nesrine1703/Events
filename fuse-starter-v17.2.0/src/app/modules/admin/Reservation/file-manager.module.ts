import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTooltipModule } from '@angular/material/tooltip';
import { SharedModule } from 'app/shared/shared.module';
import { FileManagerComponent } from './file-manager.component';
import { FileManagerDetailsComponent } from './details/details.component';
import { FileManagerListComponent } from './list/list.component';
import { fileManagerRoutes } from './file-manager.routing';
import { FuseCardModule } from '@fuse/components/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatMenuModule } from '@angular/material/menu';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';

@NgModule({
    declarations: [
        FileManagerComponent,
        FileManagerDetailsComponent,
        FileManagerListComponent,
        
    ],
    imports     : [
        RouterModule.forChild(fileManagerRoutes
        ),
        MatButtonModule,
        MatIconModule,
        MatSidenavModule,
        MatTooltipModule,
        SharedModule,
        FuseCardModule ,
        MatDialogModule,
        MatTabsModule,
        MatFormFieldModule,
        MatMenuModule ,
        MatDividerModule  ,
        MatInputModule,
        MatRadioModule,
        MatSelectModule,
        MatStepperModule ,
        MatCheckboxModule,
        
     ]
})
export class FileManagerModule
{
}
