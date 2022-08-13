package Part2.Hospital;

public class Hospital {

    public static final int MAX_TEMP = 40;
    public static final int MIN_TEMP = 32;
    public static final float MIN_TEMP_FOR_HEALTH = 36.2f;
    public static final float MAX_TEMP_FOR_HEALTH = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float [] arr = new float[patientsCount];
        for (int i = 0; i < arr.length; i++) {
            int diff = MAX_TEMP - MIN_TEMP;
            arr[i] = (float) (Math.random() * diff) + 32;
        }
        for (int i = 0; i < arr.length; i++) {
            float scale = (float) Math.pow(10,1);
            arr[i] = (float) (Math.ceil(arr[i] * scale) / scale);
        }
        return arr;
    }
    public static String getReport(float[] temperatureData) {

        StringBuilder sb = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            sb.append(temperatureDatum).append(" ");
        }
        float sum = 0;
        for (float temperatureDatum : temperatureData) {
            sum += temperatureDatum;
        }
        float midTemp = sum/temperatureData.length;
        float scale = (float) Math.pow(10,2);
        float midTempTrim = (float) (Math.ceil(midTemp * scale)/scale);

        int countHealthy  = 0;

        for (float temperatureDatum : temperatureData) {
            if (temperatureDatum >= MIN_TEMP_FOR_HEALTH
                    && temperatureDatum <= MAX_TEMP_FOR_HEALTH) {
                countHealthy++;
            }
        }

        return "Температуры пациентов: " + sb +
        "\nСредняя температура: " + midTempTrim +
        "\nКоличество здоровых: " + countHealthy;
    }
}
