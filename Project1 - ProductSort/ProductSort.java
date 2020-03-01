import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

// Define a class which reads, sorts, and outputs the products.

public class ProductSort {

    // Type of sort options.
    enum SortType {ID, BRAND, PRODUCT, PRICE, UNKNOWN};

    /**
     * Convienence method for printing.
     * @param o The object to output as a string.
     */
    public static void print(Object o) {
        System.out.println(o);
    }

    /**
     * Sort a list of Product by the brand name.
     * @param products A List of Product.
     * @return The sorted list of Product.
     */
    public static List<Product> sortByBrandName(List<Product> products) {

        Product[] productArray = new Product[products.size()];
        productArray = products.toArray(productArray);
        for ( int i = 1; i < productArray.length; ++i ) {
            Product temp = productArray[i];
            int j = i-1;
            while ( j >= 0 && temp.getBrandName().compareToIgnoreCase(productArray[j].getBrandName()) < 0 ) {
                productArray[j+1] = productArray[j];
                --j;
            }
            productArray[j+1] = temp;

        }
        return new ArrayList<Product>(Arrays.asList(productArray));
    }

    /**
     * Sort a list of Product by the product name.
     * @param products A List of Product.
     * @return The sorted list of Product.
     */

    public static List<Product> sortByProductName(List<Product> products) {

        Product[] productArray = new Product[products.size()];
        productArray = products.toArray(productArray);
        for ( int i = 1; i < productArray.length; ++i ) {
            Product temp = productArray[i];
            int j = i-1;
            while ( j >= 0 && temp.getProductName().compareToIgnoreCase(productArray[j].getProductName()) < 0 ) {
                productArray[j+1] = productArray[j];
                --j;
            }
            productArray[j+1] = temp;

        }
        return new ArrayList<Product>(Arrays.asList(productArray));
    }

    /**
     * Sort a list of Product by the ID.
     * @param products A List of Product.
     * @return The sorted list of Product.
     */

    public static List<Product> sortByID(List<Product> products) {

        Product[] productArray = new Product[products.size()];
        productArray = products.toArray(productArray);
        for ( int i = 1; i < productArray.length; ++i ) {
            Product temp = productArray[i];
            int j = i-1;
            while ( j >= 0 && temp.getId() < productArray[j].getId() ) {
                productArray[j+1] = productArray[j];
                --j;
            }
            productArray[j+1] = temp;

        }
        return new ArrayList<Product>(Arrays.asList(productArray));
    }

    /**
     * Sort a list of Product by the price.
     * @param products A List of Product.
     * @return The sorted list of Product.
     */

    public static List<Product> sortByPrice(List<Product> products) {

        Product[] productArray = new Product[products.size()];
        productArray = products.toArray(productArray);
        for ( int i = 1; i < productArray.length; ++i ) {
            Product temp = productArray[i];
            int j = i-1;
            while ( j >= 0 && temp.getPrice() < productArray[j].getPrice() ) {
                productArray[j+1] = productArray[j];
                --j;
            }
            productArray[j+1] = temp;

        }
        return new ArrayList<Product>(Arrays.asList(productArray));
    }


    /**
     * The main function.
     *
     * @param args The arguments passed into the program.
     */
    public static void main(String[] args) {

        String inputFile = null;
        String outputFile = null;
        SortType sortBy = SortType.UNKNOWN;
        Scanner sc = null;
        PrintWriter pw = null;
        List<Product> sortList = null;

        // Inputs arguments must be either one or three parameters.
        if (args.length != 1 && args.length != 3) {
            print("Uh oh! What you did there is not going to work, you can only pass in a category to sort by or optionally pass in an input file and output file as well.");
            exit(1);
        }

        // Check for valid sort criteria.
		switch (args[0].toLowerCase()) {

			case "brand":
			    sortBy = SortType.BRAND;
                break;
			case "product":
                sortBy = SortType.PRODUCT;
                break;
			case "price":
                sortBy = SortType.PRICE;
                break;
			case "id":
			    sortBy = SortType.ID;
			    break;

            default:
                print("Invalid sorting criteria. Sort by one of these: 'brand', 'product', 'price', or 'id'");
                exit(2);
		}

		// Get the input and output files from the command line if passed.
		if ( args.length == 3 ) {
            inputFile = args[1];
            outputFile = args[2];

        }

        // Read from a file.
        if ( inputFile != null ) {
		    File inFile = new File(inputFile);

            try {
                sc = new Scanner(inFile);
            }
            catch(FileNotFoundException e) {
                print("Unable to open input file: " + inputFile);
                exit(3);
            }

        }
        // Else read from standard input.
        else {
            sc = new Scanner(System.in);
            print("Enter the number of records, followed by the tab delimited records (id, brand name, product name, price).");
        }

        // Open the output to a file.
        if ( outputFile != null ) {
            File outFile = new File(outputFile);
            try {
                pw = new PrintWriter(outFile);
                print("Output will be written to the following file: " + outputFile);
            }
            catch(FileNotFoundException e ) {
                print("Unable to open output file: " + outputFile);
                exit(4);
            }
        }
        // Else write to STDOUT.
        else {
            pw = new PrintWriter(System.out);
        }

        // Read the input from the appropriate source.
        List<Product> prodList = read(sc);


		// Sort the input by the indicated attribute.
		switch(sortBy) {
            case ID:
                sortList = sortByID(prodList);
                break;
            case PRICE:
                sortList = sortByPrice(prodList);
                break;
            case BRAND:
                sortList = sortByBrandName(prodList);
                break;
            case PRODUCT:
                sortList = sortByProductName(prodList);
                break;
            default:
                print("Unexpected sort method indicated!!");
                // Do nothing, shouldn't ever get here!
        }

        // Write the output to the appropriate destination.
        write(pw, sortList);

		print("Processing completed.");

    } // end of main


    /**
     * Read product inputs.
     *
     * @param scan The Scanner object.
     * @return A list of valid product objects.
     */
    private static List<Product> read(Scanner scan) {
        List<Product> list = new ArrayList<Product>();
        Long id, price;
        String brand, product;
        int cntExpected = 30; // set to artificially high number
        int cntRead = 0;
        boolean first = true;
        String line;


        // Read each line of input until we read the expected number of records.
        while ( cntRead < cntExpected ) {

            if ( scan.hasNextLine() ) {
                line = scan.nextLine();
                //print(line);
                // Read the first line, which is the count of entries.
                if (first) {
                    try {
                        cntExpected = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        print("Expecting an integer representing the number of records to follow. Program terminating.");
                        exit(8);
                    }
                    //print("Count: " + cntExpected);
                    first = false;
                    continue;
                }
                // Count the number of records read.
                cntRead++;

                // Break the line into tokens using tab as the delimiter.
                String[] tokens = line.split("\\t");

                // There should be four tokens, if not read next line.
                if (tokens.length != 4) {
                    print("Bad record, number of tokens: " + tokens.length);
                    continue;
                }
                //print("- " + tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3]);

                // Try to convert the tokens into their native types.
                // If an exception is thrown, reject this line and read the next line.
                try {
                    id = Long.parseLong(tokens[0]);
                    // Reject IDs that are too big!
                    if (id >= 10000000000L) {
                        print("Bad record, ID is too large: " + id);
                        continue;
                    }
                    brand = tokens[1];
                    product = tokens[2];
                    price = Long.parseLong(tokens[3]);
                }
                // If an exception is thrown, then the conversion to long failed.
                // We consider this bad input, so skip the line.
                catch (Exception e) {
                    //print("Exception: " + e);
                    print("Failed to parse the following line: " + line);
                    continue;
                }

                // Looks good, so create a new product object and add to the list.
                list.add(new Product(id, brand, product, price));
                //print("Added line: " +line);
            } // end if has next line
        } // end while

        scan.close();
        return list;
    }

    /**
     * Write to the indicated output all the products.
     * @param pw The PrintWriter being used.
     * @param list The Product list.
     */
    private static void write(PrintWriter pw, List<Product> list) {

        pw.write(list.size() + "\n");
        for(int i = 0; i < list.size(); i++ ) {
            pw.write(list.get(i).toString() + "\n");
        }

        pw.close();
    }


}


