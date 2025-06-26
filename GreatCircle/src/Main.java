//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double lat1 = Double.parseDouble(args[0]);
        double lon1 = Double.parseDouble(args[1]);
        double lat2 = Double.parseDouble(args[2]);
        double lon2 = Double.parseDouble(args[3]);

        double distanceKm = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println(distanceKm + " kilometers");

    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double EarthRadiusKm = 6371.0;
        double pi = 3.14159265358979323846;
        // Convert latitude and longitude from degrees to radians
        double lat1Rad = lat1 * (pi / 180);
        double lon1Rad = lon1 * (pi / 180);
        double lat2Rad = lat2 * (pi / 180);
        double lon2Rad = lon2 * (pi / 180);

        // Differences in coordinates
        double latDiff = lat2Rad - lat1Rad;
        double lonDiff = lon2Rad - lon1Rad;

        // Haversine formula
        double a = Math.pow(Math.sin(latDiff / 2), 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.pow(Math.sin(lonDiff / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate distance
        return EarthRadiusKm * c;
    }
}