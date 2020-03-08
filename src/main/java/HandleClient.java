import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortingAlgorithm {
    HashMap<String, Double> patient_scores = new HashMap<String,Double>();
    List<Double> patientSorted = new ArrayList<Double>();
    double total_score;

    public void addPatient(String name, double priority, double scans) {
        double arrivalTime = System.currentTimeMillis();
        total_score = priority*0.6 + scans*0.2;
        patient_scores.put(name, total_score);
        patientSorted.add(total_score);
        updateList();
    }

    public void updateList() {
        Collections.sort(patientSorted);
        Collections.reverse(patientSorted);
    }

    public String selectNextPatient() {
        for (String patient : patient_scores.keySet()) {
            if (patient_scores.get(patient) == patientSorted.get(0)) {
                return patient;
            }
        }
        return "Error finding patient";
    }

}
