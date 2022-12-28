// package com.m_code.Fawry.UI;
//
// import java.util.ArrayList;
// import java.util.Scanner;
// import Auth.SqlLite;
// import Auth.Handlers.AdminAuthHandler;
// import Auth.Handlers.AuthHandler;
// import Auth.Handlers.UserAuthHandler;
// import Auth.Models.Admin;
// import Auth.Models.User;
// import RuntimeData.DataStoreRuntime;
// import Services.AbstractService.AbstractService;
//
// public class MainMenuView {
// //
// // String name = sc.next();
// // System.out.println("Enter your email: ");
// String email = sc.next();
// System.out.println("Enter your password: ");
// String password = sc.next();
// auth = new UserAuthHandler();
// if (auth.Register(name, email, password)) {
// System.out.println("Registration successful");
// } else {
// System.out.println("Registration failed");
// displayAuthMenu();
// }
// } else if (option == 4) {
// System.out.println("Exiting program!");
// System.exit(0);
// } else {
// System.out.println("Invalid option");
// displayAuthMenu();
// }
// } catch (Exception e) {
// System.out.println("Invalid input");
// displayAuthMenu();
// }
// }
//
// public static void showServices() {
// DataStoreRuntime dts = DataStoreRuntime.getInstance();
// ArrayList<AbstractService> services = dts.getServices();
// ArrayList<String> serviceNames = dts.getServicesNames();
// ArrayList<AbstractService> filteredBySearch = new
// ArrayList<AbstractService>();
// int option, selectedService;
// String search;
// Scanner sc = new Scanner(System.in);
// System.out.println("Avaliable Services:");
// try {
// option = InputValidator.validateInputServices(serviceNames);
// if (option == serviceNames.size() + 2) {
// User.userOptionsMenu();
// } else if (option == serviceNames.size() + 1) {
// System.out.println("Enter the name of the service provider you want to search
// for");
// search = sc.nextLine();
// for (AbstractService service : services) {
// if
// (service.getServiceProviderName().toLowerCase().contains(search.toLowerCase()))
// {
// filteredBySearch.add(service);
// }
// }
// } else {
// for (AbstractService service : services) {
// if (service.getServiceName().equals(serviceNames.get(option - 1))) {
// filteredBySearch.add(service);
// }
// }
// }
// selectedService =
// InputValidator.validateInputServicesProviders(filteredBySearch);
// if (selectedService == filteredBySearch.size() + 1) {
// showServices();
// }
// filteredBySearch.get(selectedService - 1).pay();
// showServices();
// } catch (Exception e) {
// System.out.println(e.getMessage());
// System.out.println("Invalid input");
// showServices();
// }

// }

// }
//