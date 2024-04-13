export interface Reservation {
    reservationDate: string; // Assuming you receive the date as string from the API
    numberOfTickets: number;
    isPaid: boolean;
    email: string;
    idEvent: number;
  }