package cz.spilar.storage;

import cz.spilar.exception.ParcelInfoException;
import cz.spilar.exception.StorageException;
import cz.spilar.factory.ParcelFactory;
import cz.spilar.validator.FileValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Store {

    private static final int STORAGE_PRINT_INTERVAL_SEC = 60;

    private DecimalFormat weightFormat;
    private Timer timer;
    private Map<String, List<Parcel>> storage = new HashMap<String, List<Parcel>>();

    public Store() {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        decimalFormatSymbols.setDecimalSeparator('.');
        weightFormat = new DecimalFormat("0.000", decimalFormatSymbols);
    }

    public Store(File initialStorage) throws StorageException {
        this();
        FileValidator.validateFileExtension(initialStorage, ".TXT");
        initializeStorage(initialStorage);
    }

    public void addParcel(Parcel parcel) {
        if (parcel != null) {
            if (storage.containsKey(parcel.getPostalCode())) {
                storage.get(parcel.getPostalCode()).add(parcel);
            } else {
                List<Parcel> newList = new ArrayList<>();
                newList.add(parcel);
                storage.put(parcel.getPostalCode(), newList);
            }
        }
    }

    public void startPrinting() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    printStorage();
                }
            }, 0, STORAGE_PRINT_INTERVAL_SEC * 1000);
        }
    }

    private void initializeStorage(File initialFile) {
        try {
            Scanner myReader = new Scanner(initialFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    Parcel parcel = ParcelFactory.createParcel(data);
                    addParcel(parcel);
                } catch (ParcelInfoException e) {
                    System.out.println("Unsupported parcel data. Parcel has been skipped: " + data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new StorageException(StorageException.INITIAL_FILE_NOT_FOUND_ERROR);
        }
    }

    private void printStorage() {
        System.out.println("Current storage load:");
        storage.forEach((postalCode, parcels) -> {
            double totalWeight = 0;
            for (Parcel parcel : parcels) {
                totalWeight += parcel.getWeight();
            }
            System.out.println(postalCode + " " + weightFormat.format(totalWeight));
        });
    }
}
