import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;

class TravellAgency {
    public static class cardValid {
        private Pattern pattern;
        private Matcher matcher;
        private static final String CARD_PATTERN = "^[0-9]{4}$";

        public cardValid() {
            pattern = Pattern.compile(CARD_PATTERN);
        }

        public boolean validate(final String hex) {
            matcher = pattern.matcher(hex);
            return matcher.matches();
        }
    }

    public static class cvvValid {
        private Pattern pattern;
        private Matcher matcher;
        private static final String CVV_PATTERN = "^[0-9]{3}$";

        public cvvValid() {
            pattern = Pattern.compile(CVV_PATTERN);
        }

        public boolean validate(final String hex) {
            matcher = pattern.matcher(hex);
            return matcher.matches();
        }
    }

    private static final String[] adjectives = { "Royal", "Grand", "Luxury", "Elegant", "Cozy", "Charming",
            "Comfortable", "Modern", "Quaint", "Serene" };
    private static final String[] nouns = { "Palace", "Residency", "Mansion", "Manor", "Estate", "Retreat", "Inn",
            "Lodge", "Sanctuary", "Oasis" };

    public static class EmailValidator {
        private Pattern pattern;
        private Matcher matcher;
        private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public EmailValidator() {
            pattern = Pattern.compile(EMAIL_PATTERN);
        }

        public boolean validate(final String hex) {
            matcher = pattern.matcher(hex);
            return matcher.matches();
        }
    }

    public static boolean isValidDate(String date) {
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}$";
        return date.matches(regex);
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        // initialization
        String email, password, username, card, cvv;
        username = "";
        cvv = "";
        password = "";
        email = "";
        card = "";
        int mode = 0;
        cardValid c = new cardValid();
        cvvValid cv = new cvvValid();
        String[] busNames = {
                "Kaveri Travels",
                "SRS Travels",
                "Parveen Travels",
                "VRL Travels",
                "Kallada Travels",
                "KPN Travels",
                "Kesineni Travels",
                "Orange Travels",
                "Kabra Travels",
                "Sharma Travels",
                "Jabbar Travels",
                "Neeta Travels",
                "KMBT Travels",
                "Sugama Travels",
                "Konduskar Travels",
                "Gujarat Travels",
                "SVR Travels",
                "National Travels",
                "Rathi Meena Travels",
                "Hans Travels",
                "KGN Travels",
                "HRTC",
                "Maharashtra Travels",
                "Kaleswari Travels",
                "Himgiri Travels",
                "Shree Khurana Travels",
                "Raj Express",
                "Raj Ratan Tours And Travels",
                "Pawan Travels",
                "Shrinath Travels",
                "Sanjay Travels",
                "Anand Travels",
                "Shubham Travels",
                "Shankar Travels",
                "Jai Bhawani Travels",
                "Jain Travels",
                "Vignesh TAT Travels",
                "JBT Travels",
                "Sai Travels",
                "Sahara Travels",
                "Royal Cruiser Travels",
                "Rishabh Travels",
                "Sangita Travels",
                "Saffron Travels",
                "KTC Tours",
                "Dolphin Travels",
                "Classic Travels",
                "Choudhary Travels",
                "Bhagirathi Travels",
                " Ashok Travels",
        };

        String[] trains = new String[50];
        String[] travellName = new String[150];
        String[] travellType = new String[150];
        int[] travellPrice = new int[150];
        int o = 0;

        trains[0] = "Rajdhani Express";
        trains[1] = "Shatabdi Express";
        trains[2] = "Duronto Express";
        trains[3] = "Garib Rath Express";
        trains[4] = "Humsafar Express";
        trains[5] = "Tejas Express";
        trains[6] = "Vande Bharat Express";
        trains[7] = "Gatimaan Express";
        trains[8] = "Sampark Kranti Express";
        trains[9] = "Jan Shatabdi Express";
        trains[10] = "Swarna Jayanti Express";
        trains[11] = "Maharaja Express";
        trains[12] = "Himsagar Express";
        trains[13] = "Karnataka Express";
        trains[14] = "Kerala Express";
        trains[15] = "Konkan Kanya Express";
        trains[16] = "Mangalore Express";
        trains[17] = "Nizamuddin Express";
        trains[18] = "Punjab Mail";
        trains[19] = "Tamil Nadu Express";
        trains[20] = "Udyan Express";
        trains[21] = "Vaishali Express";
        trains[22] = "Yercaud Express";
        trains[23] = "Chennai Express";
        trains[24] = "Dakshin Express";
        trains[25] = "Falaknuma Express";
        trains[26] = "Gangakaveri Express";
        trains[27] = "Haripriya Express";
        trains[28] = "Ispat Express";
        trains[29] = "Jodhpur Express";
        trains[30] = "Kongu Express";
        trains[31] = "Lalbagh Express";
        trains[32] = "Mumbai Express";
        trains[33] = "Nagawali Express";
        trains[34] = "Puducherry Express";
        trains[35] = "Raptisagar Express";
        trains[36] = "Sarnath Express";
        trains[37] = "Tippu Express";
        trains[38] = "Ujjaini Express";
        trains[39] = "Visakha Express";
        trains[40] = "Yeshvantapur Express";
        trains[41] = "Bagmati Express";
        trains[42] = "Chamundi Express";
        trains[43] = "Deccan Queen Express";
        trains[44] = "Godavari Express";
        trains[45] = "Intercity Express";
        trains[46] = "Kacheguda Express";
        trains[47] = "Lingampalli Express";
        trains[48] = "Mandovi Express";
        trains[49] = "Nilgiri Mountain Railway";
        Scanner in = new Scanner(System.in);
        String[] cities = { "agra", "ahmedabad", "allahabad", "amritsar", "aurangabad", "bagdogra", "bangalore",
                "bhavnagar", "bhopal", "bhubaneswar", "bhuj", "chandigarh", "chennai", "coimbatore", "dehradun",
                "delhi", "dibrugarh", "dimapur", "diu", "gaya", "goa", "gorakhpur", "guwahati", "hyderabad", "imphal",
                "indore", "jabalpur", "jaipur", "jammu", "jamnagar", "jamshedpur", "jodhpur", "kanpur", "kochi",
                "kolhapur", "kolkata", "kullu", "leh", "lucknow", "ludhiana", "madurai", "mangalore", "mumbai",
                "nagpur", "nanded", "nashik", "new delhi", "patna", "pune", "porbandar", "port blair", "raipur",
                "rajahmundry", "rajkot", "ranchi", "shillong", "shimla", "silchar", "srinagar", "surat",
                "tiruchirapalli", "tirupati", "udaipur", "vadodara", "varanasi", "vijayawada", "vishakhapatnam" };
        String[] airlineCompanies = { "Air India", "SpiceJet", "IndiGo", "Vistara", "GoAir", "AirAsia India" };
        String[] greetings = { "Hello", "Hi", "Yo", "What's up", "Howdy", "Bonjour", "Hola", "Ciao", "Guten tag",
                "Namaste", "Konichiwa", "Sawatdee", "Shalom" };
        Random random = new Random();
        int roundtype = 0;
        String date1 = "", date2 = "";
        // Login / Register Code
        System.out.println("Welcome to Travell Agency");
        System.out.println("Please Select an Option");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Select Operation: ");
        int option = in.nextInt();
        switch (option) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter Email: ");
                    email = in.next();
                    EmailValidator emailValidator = new EmailValidator();
                    if (emailValidator.validate(email)) {
                        i = 3;
                        break;
                    } else {
                        System.out.println("Invalid Email");
                        i = 1;
                    }
                }
                System.out.print("Enter Password: ");
                password = in.next();
                int index = email.indexOf('@');
                username = email.substring(0, index);
                // Login Code
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter Email: ");
                    email = in.next();
                    EmailValidator emailValidator = new EmailValidator();
                    if (emailValidator.validate(email)) {
                        i = 3;
                        break;
                    } else {
                        System.out.println("Invalid Email");
                        i = 1;
                    }
                }
                System.out.println("Enter Password");
                password = in.next();
                int index1 = email.indexOf('@');
                username = email.substring(0, index1);
                // Register Code
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        // Greetings Code
        System.out.println(greetings[random.nextInt(11)] + " " + username);
        // Menu Code
        int cd = 0;
        String source = "", destination = "";
        for (int i = 0; i <= 3; i++) {
            System.out.print("Enter Your Source: ");
            source = in.next();
            System.out.print("Enter Your Destination: ");
            destination = in.next();
            for (int j = 0; j < cities.length; j++) {
                if (source.equalsIgnoreCase(cities[j])) {
                    cd++;
                }
                if (destination.equalsIgnoreCase(cities[j])) {
                    cd++;
                }
            }
            if (cd == 2) {
                break;
            } else {
                System.out.println("Invalid Source or Destination");
            }
        }
        System.out.print("Enter number of passengers: ");
        int passengers = in.nextInt();
        // Travell Mode Code
        System.out.println("Select an Option to choose your travell mode: ");
        System.out.println("1. Air");
        System.out.println("2. Train");
        System.out.println("3. Bus");
        System.out.println("4. Exit");
        System.out.print("Enter Option: ");
        int option1 = in.nextInt();
        String[] areoplaneName = new String[6];
        int[] areoplanePrice = new int[6];
        switch (option1) {
            case 1:
                mode = 1;

                System.out.println("Choose your way:");
                System.out.println("1. One Way");
                System.out.println("2. Round Trip");
                System.out.println("3. Exit");
                System.out.print("Enter Option: ");
                int option2 = in.nextInt();
                switch (option2) {
                    case 1:
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Enter Your travell date in dd/mm/yyyy format: ");
                            date1 = in.next();
                            if (isValidDate(date1)) {
                                i = 4;
                                break;
                            } else {
                                System.out.println(
                                        "Invalid Date: " + date1 + " Please Enter Valid Date in dd/mm/yyyy format");
                                i = 1;
                            }
                        }
                        roundtype = 1;

                        break;
                    case 2:
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Enter Your travell date in dd/mm/yyyy format: ");
                            date1 = in.next();
                            if (isValidDate(date1)) {
                                i = 4;
                                break;
                            } else {
                                System.out.println(
                                        "Invalid Date: " + date1 + " Please Enter Valid Date in dd/mm/yyyy format");
                                i = 1;
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Enter Your return date in dd/mm/yyyy format: ");
                            date2 = in.next();
                            if (isValidDate(date1)) {
                                i = 4;
                                break;
                            } else {
                                System.out.println(
                                        "Invalid Date: " + date1 + " Please Enter Valid Date in dd/mm/yyyy format");
                                i = 1;
                            }
                        }
                        roundtype = 2;
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                }
                System.out.println("Choose your class:");
                System.out.println("1. Economy");
                System.out.println("2. Business");
                System.out.println("3. First");
                System.out.println("4. Premium Economy");
                System.out.println("5. Exit");
                System.out.print("Enter Option: ");
                int option3 = in.nextInt();
                switch (option3) {
                    case 1:
                        System.out.println("Geting your flight details");
                        try {
                            Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Flight Details");
                        if (roundtype == 1) {
                            for (int i = 0; i < airlineCompanies.length; i++) {
                                int fare = random.nextInt(3000) * roundtype * passengers + 2000;

                                System.out.println("");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(i + ". " + airlineCompanies[i] + "-"
                                        + String.format("6E%d", random.nextInt(900000) + 10000) + " || Travell Date: "
                                        + date1 + "|| Total Fare: "
                                        + fare + " || Seats Available: " + random.nextInt(100));
                                        travellName[i] = airlineCompanies[i];
                                        travellType[i] = "Air";
                                        travellPrice[i] = fare;
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Geting your flight details");
                            try {
                                Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Flight Details");
                            if (roundtype == 2) {
                                for (int i = 0; i < airlineCompanies.length; i++) {
                                    int fare = random.nextInt(3000) * roundtype * passengers + 3000;
                                    travellName[i] = airlineCompanies[i];
                                    travellType[i] = "Air";
                                    travellPrice[i] = fare;
                                    System.out.println("");
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(i + ". " + airlineCompanies[i] + "-"
                                            + String.format("6E%d", random.nextInt(900000) + 10000)
                                            + " || Travell Date: "
                                            + date1 + "|| Return Date:" + date2 + "|| Total Fare: "
                                            + fare + " || Seats Available: " + random.nextInt(100));
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    try {
                                        Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Geting your flight details");
                        try {
                            Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Flight Details (Bussiness)");
                        if (roundtype == 1) {
                            for (int i = 0; i < airlineCompanies.length; i++) {
                                int fare = random.nextInt(3000) * roundtype * passengers + 4000;
                                travellName[i] = airlineCompanies[i];
                                travellType[i] = "Air";
                                travellPrice[i] = fare;
                                System.out.println("");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(i + ". " + airlineCompanies[i] + "-"
                                        + String.format("6E%d", random.nextInt(900000) + 10000) + " || Travell Date: "
                                        + date1 + "|| Total Fare: "
                                        + fare + " || Seats Available: " + random.nextInt(100));
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Geting your flight details");
                            try {
                                Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Flight Details (Bussiness)");
                            for (int i = 0; i < airlineCompanies.length; i++) {
                                int fare = random.nextInt(3000) * roundtype * passengers + 5000;
                                travellName[i] = airlineCompanies[i];
                                travellType[i] = "Air";
                                travellPrice[i] = fare;
                                System.out.println("");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(i + ". " + airlineCompanies[i] + "-"
                                        + String.format("6E%d", random.nextInt(900000) + 10000)
                                        + " || Travell Date: "
                                        + date1 + "|| Return Date:" + date2 + "|| Total Fare: "
                                        + fare + " || Seats Available: " + random.nextInt(100));
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Geting your flight details (First)");
                        try {
                            Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Flight Details");
                        if (roundtype == 1) {
                            for (int i = 0; i < airlineCompanies.length; i++) {
                                int fare = random.nextInt(3000) * roundtype * passengers + 3000;
                                travellName[i] = airlineCompanies[i];
                                travellType[i] = "Air";
                                travellPrice[i] = fare;
                                System.out.println("");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(i + ". " + airlineCompanies[i] + "-"
                                        + String.format("6E%d", random.nextInt(900000) + 10000) + " || Travell Date: "
                                        + date1 + "|| Total Fare: "
                                        + fare + " || Seats Available: " + random.nextInt(100));
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Geting your flight details");
                            try {
                                Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Flight Details");
                            if (roundtype == 2) {
                                for (int i = 0; i < airlineCompanies.length; i++) {
                                    int fare = random.nextInt(3000) * roundtype * passengers + 4000;
                                    travellName[i] = airlineCompanies[i];
                                    travellType[i] = "Air";
                                    travellPrice[i] = fare;
                                    System.out.println("");
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(i + ". " + airlineCompanies[i] + "-"
                                            + String.format("6E%d", random.nextInt(900000) + 10000)
                                            + " || Travell Date: "
                                            + date1 + "|| Return Date:" + date2 + "|| Total Fare: "
                                            + fare + " || Seats Available: " + random.nextInt(100));
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    try {
                                        Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Geting your flight details (Premium Economy)");
                        try {
                            Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Flight Details");
                        if (roundtype == 1) {
                            for (int i = 0; i < airlineCompanies.length; i++) {
                                int fare = random.nextInt(3000) * roundtype * passengers + 5000;
                                travellName[i] = airlineCompanies[i];
                                travellType[i] = "Air";
                                travellPrice[i] = fare;
                                System.out.println("");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(i + ". " + airlineCompanies[i] + "-"
                                        + String.format("6E%d", random.nextInt(900000) + 10000) + " || Travell Date: "
                                        + date1 + "|| Total Fare: "
                                        + fare + " || Seats Available: " + random.nextInt(100));
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Geting your flight details");
                            try {
                                Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Flight Details");
                            if (roundtype == 2) {
                                for (int i = 0; i < airlineCompanies.length; i++) {
                                    int fare = random.nextInt(3000) * roundtype * passengers + 6000;
                                    travellName[i] = airlineCompanies[i];
                                    travellType[i] = "Air";
                                    travellPrice[i] = fare;
                                    System.out.println("");
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(i + ". " + airlineCompanies[i] + "-"
                                            + String.format("6E%d", random.nextInt(900000) + 10000)
                                            + " || Travell Date: "
                                            + date1 + "|| Return Date:" + date2 + "|| Total Fare: "
                                            + fare + " || Seats Available: " + random.nextInt(100));
                                    System.out.println(
                                            "-------------------------------------------------------------------------------------------------------------------------------");
                                    try {
                                        Thread.sleep(1000); // sleep for 1000 milliseconds (1 second)
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        break;

                }
                System.out.print("Select your option: ");
                o = in.nextInt();
                System.out.println("Select your payment method");
                System.out.println("1. Credit Card");
                System.out.println("2. Debit Card");
                System.out.println("3. Net Banking");
                System.out.println("4. Exit");
                System.out.print("Select your payment method: ");
                int p = in.nextInt();
                if (p == 4) {
                    System.exit(0);
                }
                if (p == 1 || p == 2) {

                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your last four digits of your card: ");
                        card = in.next();
                        if (c.validate(card)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid card number");
                        }

                    }
                    System.out.println("**** **** **** " + card);
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your CVV: ");
                        cvv = in.next();
                        if (cv.validate(cvv)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid CVV");
                        }

                    }
                    System.out.print("Enter your card holder name: ");
                    String name = in.next();
                    System.out.print("Enter your card expiry date: ");
                    String date = in.next();
                    System.out.println(
                            "Processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");
                    System.out.println("Have a nice day :)");
                }
                if (p == 3) {
                    System.out.println("Select your bank");
                    System.out.println("1. SBI");
                    System.out.println("2. HDFC");
                    System.out.println("3. ICICI");
                    System.out.println("4. Axis");
                    System.out.println("5. Kotak");
                    System.out.println("6. Exit");
                    int bank = in.nextInt();
                    if (bank == 6) {
                        System.exit(0);
                    }
                    System.out.println("Enter your username");
                    String user = in.next();
                    System.out.println("Enter your last four digits of your password");
                    int pass = in.nextInt();
                    System.out.println(
                            "System is processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");

                    System.out.println("Have a nice day :)");

                }
                break;
            case 2:
                mode = 2;
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter Your travell date in dd/mm/yyyy format: ");
                    date1 = in.next();
                    if (isValidDate(date1)) {
                        i = 4;
                        break;
                    } else {
                        System.out.println("Invalid Date: " + date1 + " Please Enter Valid Date in dd/mm/yyyy format");
                        i = 1;
                    }
                }
                System.out.println("Getting all train details");
                try {
                    Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Train Details");
                for (int i = 0; i < trains.length; i++) {
                    System.out.println("");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(i + 1 + ". " + trains[i] + "|| " + source + " -------------> " + destination
                            + "  || Travell Date: " + date1 + "|| Total Fare: " + random.nextInt(3000) * passengers
                            + " || Seats Available: " + random.nextInt(100) + " || Travell Date: " + date1);
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------------");
                }
                System.out.print("Select your option: ");
                o = in.nextInt();
                System.out.println("Select your payment method");
                System.out.println("1. Credit Card");
                System.out.println("2. Debit Card");
                System.out.println("3. Net Banking");
                System.out.println("4. Exit");
                int p1 = in.nextInt();
                if (p1 == 4) {
                    System.exit(0);
                }
                if (p1 == 1 || p1 == 2) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your last four digits of your card: ");
                        card = in.next();
                        if (c.validate(card)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid card number");
                        }

                    }
                    System.out.println("**** **** **** " + card);
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your CVV: ");
                        cvv = in.next();
                        if (cv.validate(cvv)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid CVV");
                        }

                    }
                    System.out.print("Enter your card holder name: ");
                    String name = in.next();

                    String date = in.next();
                    System.out.println(
                            "Processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");
                    System.out.println("Have a nice day :)");
                }
                if (p1 == 3) {
                    System.out.println("Select your bank");
                    System.out.println("1. SBI");
                    System.out.println("2. HDFC");
                    System.out.println("3. ICICI");
                    System.out.println("4. Axis");
                    System.out.println("5. Kotak");
                    System.out.println("6. Exit");
                    int bank = in.nextInt();
                    if (bank == 6) {
                        System.exit(0);
                    }
                    System.out.println("Enter your username");
                    String user = in.next();
                    System.out.println("Enter your last four digits of your password");
                    int pass = in.nextInt();
                    System.out.println(
                            "System is processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");

                    System.out.println("Have a nice day :)");

                }
                break;
            case 3:
                mode = 3;
                System.out.println("SkyHigh Travells (Interstate)");
                try {
                    Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter Your Source (interstate): ");
                    source = in.next();
                    System.out.print("Enter Your Destination (interstate): ");
                    destination = in.next();
                    for (int j = 0; j < cities.length; j++) {
                        if (source.equalsIgnoreCase(cities[j])) {
                            i++;
                        }
                        if (!destination.equalsIgnoreCase(cities[j])) {
                            i++;
                        }
                    }
                    if (cd == 2) {
                        break;
                    } else {
                        System.out.println("Please enter a valid source and destination (interstate)");
                    }
                }
                for (int ini = 1; ini < busNames.length; ini++) {
                    int ias = ini - 1;
                    if (ini == 49) {
                        ias = 48;
                    }
                    System.out.println("");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(ini + ". " + busNames[ias] + "|| " + source + " -------------> "
                            + destination
                            + "  || Travell Date: " + date1 + "|| Total Fare: " + random.nextInt(3000) * passengers
                            + " || Seats Available: " + random.nextInt(100));
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------------");
                }

                System.out.print("Select your option: ");
                o = in.nextInt();
                System.out.println("Select your payment method");
                System.out.println("1. Credit Card");
                System.out.println("2. Debit Card");
                System.out.println("3. Net Banking");
                System.out.println("4. Exit");
                int p3 = in.nextInt();
                if (p3 == 4) {
                    System.exit(0);
                }
                if (p3 == 1 || p3 == 2) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your last four digits of your card: ");
                        card = in.next();
                        if (c.validate(card)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid card number");
                        }

                    }
                    System.out.println("**** **** **** " + card);
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your CVV: ");
                        cvv = in.next();
                        if (cv.validate(cvv)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid CVV");
                        }

                    }
                    System.out.print("Enter your card holder name: ");
                    String name = in.next();

                    String date = in.next();
                    System.out.println(
                            "Processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");
                    System.out.println("Have a nice day :)");
                }
                if (p3 == 3) {
                    System.out.println("Select your bank");
                    System.out.println("1. SBI");
                    System.out.println("2. HDFC");
                    System.out.println("3. ICICI");
                    System.out.println("4. Axis");
                    System.out.println("5. Kotak");
                    System.out.println("6. Exit");
                    int bank = in.nextInt();
                    if (bank == 6) {
                        System.exit(0);
                    }
                    System.out.println("Enter your username");
                    String user = in.next();
                    System.out.println("Enter your last four digits of your password");
                    int pass = in.nextInt();
                    System.out.println(
                            "System is processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");

                    System.out.println("Have a nice day :)");

                }

                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }

        System.out.println("Do you want to book a hotel?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        String[] hotelNames = new String[100];
        for (int i = 0; i < 100; i++) {
            String adjective = adjectives[random.nextInt(adjectives.length)];
            String noun = nouns[random.nextInt(nouns.length)];
            hotelNames[i] = adjective + " " + noun;
        }
        int hotel = in.nextInt();
        switch (hotel) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    System.out.println("");
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------");
                    System.out.println(i + 1 + ". " + hotelNames[random.nextInt(99)] + "|| Price for " + passengers
                            + " passengers: " + random.nextInt(10000) * passengers);
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------");
                }
                System.out.println("Select a hotel: ");
                int h = in.nextInt();
                System.out.println("Select your payment method: ");
                System.out.println("1. Credit Card");
                System.out.println("2. Debit Card");
                System.out.println("3. Net Banking");
                System.out.println("4. Exit");
                System.out.print("Select your payment option: ");
                int p4 = in.nextInt();
                if (p4 == 4) {
                    System.exit(0);
                }
                if (p4 == 1 || p4 == 2) {

                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your last four digits of your card: ");
                        card = in.next();
                        if (c.validate(card)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid card number");
                        }

                    }
                    System.out.println("**** **** **** " + card);
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter your CVV: ");
                        cvv = in.next();
                        if (cv.validate(cvv)) {
                            i = 4;
                            break;

                        } else {
                            i = 1;
                            System.out.println("Invalid CVV");
                        }

                    }
                    System.out.print("Enter your card holder name: ");
                    String name = in.next();

                    String date = in.next();
                    System.out.println(
                            "Processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");
                    System.out.println("Have a nice day :)");
                }
                if (p4 == 3) {
                    System.out.println("Select your bank");
                    System.out.println("1. SBI");
                    System.out.println("2. HDFC");
                    System.out.println("3. ICICI");
                    System.out.println("4. Axis");
                    System.out.println("5. Kotak");
                    System.out.println("6. Exit");
                    int bank = in.nextInt();
                    if (bank == 6) {
                        System.exit(0);
                    }
                    System.out.println("Enter your username");
                    String user = in.next();
                    System.out.println("Enter your last four digits of your password");
                    int pass = in.nextInt();
                    System.out.println(
                            "System is processing your payment...... We never ask for your OTP or PIN, Please do not share it with anyone");
                    try {
                        Thread.sleep(3000); // sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Payment Successful");
                    System.out.println("Your ticket has been booked");
                    System.out.println("Your ticket details has been sent to your email");
                    System.out.println("Thank you for booking with us");
                    System.out.println(travellName[o] + "Lala" + travellPrice[o]);
                    System.out.println("Have a nice day :)");
                    

                }
                break;

            case 2:
                System.exit(0);
                break;

            default:
                break;
        }

        in.close();
    }
}
