package cz.spilar;

import cz.spilar.exception.ParcelInfoException;
import cz.spilar.exception.StorageException;
import cz.spilar.factory.ParcelFactory;
import cz.spilar.storage.Parcel;
import cz.spilar.storage.Store;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static final String ACTION_END = "quit";

    public static void main(String[] args) {
        Store store;
        if (args.length > 0 && StringUtils.isNotBlank(args[0])) {
            System.out.println("Trying to initialize storage from file " + args[0]);
            File inputFile = new File(args[0]);
            try {
                store = new Store(inputFile);
            } catch (StorageException e) {
                printErrorMessage(e);
                store = new Store();
            }
        } else {
            store = new Store();
        }

        Scanner choose = new Scanner(System.in);
        String choice = null;
        store.startPrinting();
        System.out.println("Parcel storage");
        System.out.println("Type \"" + ACTION_END + "\" to end the program.");
        while (!ACTION_END.equals(choice)) {
            System.out.println("\nEnter a new package in format \"[WEIGHT] [POSTAL_CODE]\". Type \"" + ACTION_END + "\" to end the program.");
            choice = choose.nextLine();
            if (!ACTION_END.equals(choice)) {
                try {
                    Parcel parcel = ParcelFactory.createParcel(choice);
                    store.addParcel(parcel);
                } catch (ParcelInfoException e) {
                    printErrorMessage(e);
                }
            }
        }
        System.exit(0);
    }

    private static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
