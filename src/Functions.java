import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Functions {
  // Input text from console
  public static String input_text(String label) {
    try {
      System.out.print(Color("yellow") + label + Color("reset"));
      // Call of system.in to read input from console by bufferedreader
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      // Write string with stream from buffer
      String text = reader.readLine();

      return text;
    } catch (IOException exception) {
      exception.printStackTrace();
      return exception.toString();
    }
  }

  // Function of symbols of ANSI to change color of text in console
  public static String Color(String color) {
    switch(color) {
      case("red"):
        return "\u001B[31m";
      case("green"):
        return "\u001B[32m";
      case("blue"):
        return "\u001B[34m";
      case("reset"):
        return "\u001B[0m";
      case("yellow"):
        return "\u001B[33m";
      case("purple"):
        return "\u001B[35m";
      default:
        return "";
    }
  }

  // This function create empty list at first call of one overloading method
  public static ArrayList<Ship> create_list() {
    ArrayList<Ship> ships = new ArrayList<Ship>();

    return ships;
  }

  // Create element of collection
  public static void create_element(ArrayList<Ship> ships) {
    print_classes();

    String field = input_text("Type the index of class want to add to collection: ");
    if(!check_int(field)) return;

    String class_type = check_field(ships, field);

    switch (class_type) {
      case "1":
        ships.add(new Ship(check_name(ships), check_index(ships)));
        break;
      case "2":
        ships.add(new Sailboat(check_name(ships), check_index(ships), check_vendor(ships), check_manufacturer_code(ships)));
        break;
      case "3":
        ships.add(new Steamship(check_name(ships), check_index(ships), check_vendor(ships), check_manufacturer_code(ships)));
        break;
      case "4":
        ships.add(new Corvette(check_name(ships), check_index(ships), check_vendor(ships), check_manufacturer_code(ships)));
        break;
      default:
        create_element(ships);
    }
  }

  // Deleted element from collection by typed index
  public static void delete_element(ArrayList<Ship> ships) {
    String index = input_text("Type the id object of collection to delete it: ");
    if (!check_int(index)) return;
    check_exist_elements(ships, index);

    ships.remove(Integer.parseInt(index));
  }

  // Check that typed elements exist
  public static void check_exist_elements(ArrayList<Ship> ships, String index) {
    if (Integer.valueOf(index) > ships.size() || Integer.valueOf(index) < 0) {
      System.out.println(Color("red") + "Typed of index of object is undefined" + Color("reset"));

      Menu.menu_type_defifinition(ships);
    }
  }

  // Printed all elements of collection in console
  public static void print_all(ArrayList<Ship> ships) {
    for (int i = 0; i < ships.size(); i ++) {
      System.out.println("id=" + i + ships.get(i));
    }
  }

  // Compare two choosen elements of collection by hashCode and equals
  public static void compare_elements(ArrayList<Ship> ships) {
    String first_index = input_text("Type the id of first element to compare: ");
    check_int(first_index);
    check_exist_elements(ships, first_index);

    String second_index = input_text("Type the id of second element to compare: ");
    check_int(second_index);
    check_exist_elements(ships, second_index);

    if (ships.get(Integer.parseInt(first_index)).hashCode() ==
            ships.get(Integer.parseInt(second_index)).hashCode())
    {
      System.out.println(Color("green") + "Elements are equal by hashCode" + Color("reset"));
    }
    else
    {
      System.out.println(Color("red") + "Elements are not equal by hashCode" + Color("reset"));
    }

    if (ships.get(Integer.parseInt(first_index)).equals(ships.get(Integer.parseInt(second_index))))
    {
      System.out.println(Color("green") + "Elements are equal by method equals" + Color("reset"));
    }
    else
    {
      System.out.println(Color("red") + "Elements are not equal by method equals" +
              Color("reset"));
    }
  }

  // Check variable is int
  public static Boolean check_int(String index) {
    try {
      Integer.parseInt(index);

      return true;
    } catch (Exception exception) {
      System.out.println(Color("red") + "Type of data was incorrect, need to type number" +
              Color("reset"));

      return false;
    }
  }

  // Check name by range
  public static String check_name(ArrayList<Ship> ships) {
    String name = input_text("Type the name of ship: ");
    if (name.length() > 50) {
      System.out.println(Color("red") + "Name of ship is too large: " + Color("reset"));
      create_element(ships);
    }
    if (name.length() < 5) {
      System.out.println(Color("red") + "Name of ship is too short: " + Color("reset"));
      create_element(ships);
    }

    return name;
  }

  // Check index by range
  public static Integer check_index(ArrayList<Ship> ships) {
    String index = input_text("Type the index of ship: ");

    try {
      Integer.parseInt(index);
    } catch (Exception exception) {
      fix_value();
      create_element(ships);
    }

    if (String.valueOf(index).length() > 20) {
      System.out.println(Color("red") + "Index of object is too big: " + Color("reset"));
      create_element(ships);
    }
    if (String.valueOf(index).length() < 5) {
      System.out.println(Color("red") + "Index of object is too small: " + Color("reset"));
      create_element(ships);
    }

    return Integer.parseInt(index);
  }

  // Check vendor by range
  public static String check_vendor(ArrayList<Ship> ships) {
    String vendor = input_text("Type the name of vendor: ");
    if (vendor.length() > 25) {
      System.out.println(Color("red") + "Name of vendor is too large: " + Color("reset"));
      create_element(ships);
    }
    if (vendor.length() < 5) {
      System.out.println(Color("red") + "Name of vendor is too short: " + Color("reset"));
      create_element(ships);
    }

    return vendor;
  }

  // Check manufacturer code by range
  public static Integer check_manufacturer_code(ArrayList<Ship> ships) {
    String code = input_text("Type the manufacturer code of ship: ");

    try {
      Integer.parseInt(code);
    } catch (Exception exception) {
      fix_value();
      create_element(ships);
    }

    if (String.valueOf(code).length() > 30) {
      System.out.println(Color("red") + "Code of object is too big: " + Color("reset"));
      create_element(ships);
    }
    if (String.valueOf(code).length() < 8) {
      System.out.println(Color("red") + "Code of object is too small: " + Color("reset"));
      create_element(ships);
    }

    return Integer.parseInt(code);
  }

  public static void fix_value() {
    System.out.println(Color("red") + "Data was incorrect, type corrected data: " +
            Color("reset"));
  }

  // Print all classes to console interface
  public static void print_classes() {
    System.out.println(Color("green") + "1." + Color("reset") +
            Color("yellow") + "ship" + Color("reset"));
    System.out.println(Color("green") + "2." + Color("reset") +
            Color("yellow") + "Household" + Color("reset"));
    System.out.println(Color("green") + "3." + Color("reset") +
            Color("yellow") + "Garden" + Color("reset"));
    System.out.println(Color("green") + "4." + Color("reset") +
            Color("yellow") + "Vehicle" + Color("reset"));
  }

  // Checking exist class of object in list
  public static String check_field(ArrayList<Ship> ship, String field) {
    if (Integer.valueOf(field) > 4 || Integer.valueOf(field) < 0) {
      System.out.println(Color("red") + "Typed by you class do not exist" + Color("reset"));

      create_element(ship);
    }

    return field;
  }
}