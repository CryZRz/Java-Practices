package com.debuggeando_ideas.best_travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestTravelApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BestTravelApplication.class, args);
	}

}

/*
* @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AppUserRepository appUserRepository;
	@Override
	public void run(String... args) throws Exception {
		this.appUserRepository.findAll().forEach(user -> {
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			this.appUserRepository.save(user);
		});
	}
* */

/*
* //test mongo database
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public void run(String... args) throws Exception {
		//this.appUserRepository.findAll().forEach(System.out::println);
		System.out.println(this.appUserRepository.findByUsername("neverMore").orElseThrow());
	}
* */

//test sql database
/*

private final HotelRepositrory hotelRepository;
	private final FlyRepository flyRepository;
	private final TicketRepository ticketRepository;
	private final ReservationRepository reservationRepository;
	private final TourRepository tourRepository;
	private final CustomerRepository customerRepository;

	public BestTravelApplication(HotelRepositrory hotelRepository, FlyRepository flyRepository, TicketRepository ticketRepository, ReservationRepository reservationRepository, TourRepository tourRepository, CustomerRepository customerRepository) {
		this.hotelRepository = hotelRepository;
		this.flyRepository = flyRepository;
		this.ticketRepository = ticketRepository;
		this.reservationRepository = reservationRepository;
		this.tourRepository = tourRepository;
		this.customerRepository = customerRepository;
	}*/
/*@Override
	public void run(String... args) throws Exception {
		//var fly = flyRepository.findById(15L).get();
		//var hotel = hotelRepository.findById(7L).get();
		//var ticket = ticketRepository.findById(UUID.fromString("52345678-1234-5678-1234-567812345678")).get();
		//var reservation = reservationRepository.findById(UUID.fromString("32345678-1234-5678-1234-567812345678")).get();
		//var customer = customerRepository.findById("BBMB771012HMCRR022").get();

		//log.info(String.valueOf(fly));
		//log.info(String.valueOf(hotel));
		//log.info(String.valueOf(ticket));
		//log.info(String.valueOf(reservation));
		//log.info(String.valueOf(customer));

		//this.flyRepository.selectLessPrice(BigDecimal.valueOf(20)).forEach(f -> System.out.println(f));
		//this.flyRepository.selectBetweenPrice(BigDecimal.valueOf(10),BigDecimal.valueOf(15)).forEach(System.out::println);
		//this.flyRepository.selectOriginDestiny("Grecia", "Mexico").forEach(System.out::println);
		//var fly = this.flyRepository.findByTicketId(UUID.fromString("32345678-1234-5678-4234-567812345678"));
		//var hotel = hotelRepository.findByPriceLessThan(BigDecimal.valueOf(100));
		//hotel.forEach(p -> System.out.println(p));

		//var hotel2 = hotelRepository.findByPriceIsBetween(BigDecimal.valueOf(100),BigDecimal.valueOf(200));
		//hotel2.forEach(h -> System.out.println(h));

		//var hotel2 = hotelRepository.findByRatingGreaterThan(2);
		//hotel2.forEach(h -> System.out.println(h));

		//var hotel2 = hotelRepository.findByReservationId(UUID.fromString("22345678-1234-5678-1234-567812345678"));
		//System.out.println(hotel2);

		//var fly = flyRepository.findById(11L).orElseThrow();

		//var hotel = hotelRepository.findById(11L).orElseThrow();

		//var customer = customerRepository.findById("BBMB771012HMCRR022").orElseThrow();

		//var tour = TourEntity.builder()
				//.customer(customer).build();

		/*var ticket = TicketEntity.builder()
				.id(UUID.randomUUID())
				.price(fly.getPrice().multiply(BigDecimal.TEN))
				.arrivalDate(LocalDate.now())
				.departureDate(LocalDate.now())
				.purchaseDate(LocalDate.now())
				.customer(customer)
				.tour(tour)
				.fly(fly)
				.build();*/

		/*var reservation = ReservationEntity.builder()
				.id(UUID.randomUUID())
				.dateTimeReservation(LocalDateTime.now())
				.dateEnd(LocalDate.now().plusDays(2))
				.dateStart(LocalDate.now().plusDays(1))
				.hotel(hotel)
				.customer(customer)
				.tour(tour)
				.totalDays(1)
				.price(hotel.getPrice().multiply(BigDecimal.TEN))
				.build();

		System.out.println("---SAVING---");

		tour.addReservation(reservation);
		tour.updateReservations();

		tour.addTicket(ticket);
		tour.updateTickets();

		this.tourRepository.save(tour);

	}
*/
