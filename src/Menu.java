import java.util.ArrayList;

class Menu {
  // Main menu call function
  static void all_menu() {
    main_menu();
    menu_type_defifinition(Functions.create_list());
  }

  // Overloading method
  static void all_menu(ArrayList<Ship> ships) {
    main_menu();
    menu_type_defifinition(ships);
  }

  // Output in console all points of menu
  static void main_menu() {
    System.out.println(Functions.Color("yellow") + "Input the command" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "1" + Functions.Color("reset") + " - " +
            Functions.Color("blue") + "Add new element in collection" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "2" + Functions.Color("reset") + " - " +
            Functions.Color("blue") + "Delete element from collection by index" +
                    Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "3" + Functions.Color("reset") + " - " +
            Functions.Color("blue") + "Output the collection in console" +
                    Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "4" + Functions.Color("reset") + " - " +
            Functions.Color("blue") + "Compare two elements of collection" +
                    Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "5" + Functions.Color("reset") + " - " +
            Functions.Color("red") + "exit" + Functions.Color("reset"));
  }

  // Main menu to choose needed point
  static void menu_type_defifinition(ArrayList<Ship> ships) {
    String input = Functions.input_text("Input menu item: ");

    switch (input) {
      case "1":
        Functions.create_element(ships);
        all_menu(ships);
      case "2":
        Functions.delete_element(ships);
        all_menu(ships);
      case "3":
        Functions.print_all(ships);
        all_menu(ships);
      case "4":
        Functions.compare_elements(ships);
        all_menu(ships);
      case "5":
        System.exit(0);
      default:
        all_menu(ships);
    }
  }
}