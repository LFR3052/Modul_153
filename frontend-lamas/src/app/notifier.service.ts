import { Injectable } from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class NotifierService {

  constructor(private snackBar: MatSnackBar) { }

  showNotificatoin() {
    this.snackBar.open('Please fill the required input', 'Close',{
      duration:3000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom'
    })
  }
}
