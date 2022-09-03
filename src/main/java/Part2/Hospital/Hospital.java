package Part2.Hospital;

public class Hospital {

    public static final int MAX_TEMP = 40;
    public static final int MIN_TEMP = 32;
    public static final float MIN_TEMP_FOR_HEALTH = 36.2f;
    public static final float MAX_TEMP_FOR_HEALTH = 36.9f;
    private static int sumOfTemperatures = 0;
    private static int countHealthy = 0;
    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] arr = new float[patientsCount];

            for (int i = 0; i<arr.length; i++){
                int diff = MAX_TEMP - MIN_TEMP;
                float scale = (float) Math.pow(10, 1);
                arr[i] = (float) ((Math.ceil((Math.random() * diff) + 32))*scale)/scale;
                sumOfTemperatures += arr[i];

            if (arr[i] >= MIN_TEMP_FOR_HEALTH
                    && arr[i] <= MAX_TEMP_FOR_HEALTH) {
                countHealthy++;
            }
        }
        return arr;
    }
    public static String getReport(float[] temperatureData) {
        StringBuilder sb = new StringBuilder();
        for (float temperaturePerson : temperatureData) {
            sb.append(temperaturePerson).append(" ");
        }
        float midTemp = (float) sumOfTemperatures / temperatureData.length;
        float scale = (float) Math.pow(10, 2);
        float midTempTrim = (float) (Math.ceil(midTemp * scale) / scale);

        return "Температуры пациентов: " + sb +
                "\nСредняя температура: " + midTempTrim +
                "\nКоличество здоровых: " + countHealthy;
    }
}
