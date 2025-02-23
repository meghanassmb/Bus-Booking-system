

export class BusDetails {
  busNumber: number | undefined;
  arrivalDate: string | undefined; // Assuming string representation of LocalDate
  arrivalTime: string | undefined; // Assuming string representation of LocalTime
  totalSeats: number | undefined;
  availableSeats: number | undefined;
  source: string | undefined;
  destination: string | undefined;
  ticketPrice: number | undefined;
  admin: Admin | undefined;
  passId: Passenger | undefined;
}
export class Admin {
  adminId: number | undefined;
}

export class Passenger{

  passId: number | undefined;
  passName: string | undefined;
  source: string | undefined;
  destination: string | undefined;
}