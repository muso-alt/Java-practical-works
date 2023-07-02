public class SoftwareReliability {
    public static void main(String[] args) {
        int totalTests = 11; // Общее количество тестов
        int detectedErrors = 2; // Количество обнаруженных ошибок
        int[] errorTests = {4, 11}; // Номера тестов, на которых были обнаружены ошибки

        int remainingErrors = calculateRemainingErrors(totalTests, detectedErrors, errorTests);
        System.out.println("Количество оставшихся ошибок в программе: " + remainingErrors);
    }

    // Метод для расчета количества оставшихся ошибок в программе
    public static int calculateRemainingErrors(int totalTests, int detectedErrors, int[] errorTests) {
        int remainingErrors = detectedErrors;

        for (int test : errorTests) {
            if (test > totalTests) {
                break; // Если номер теста превышает общее количество тестов, выходим из цикла
            }
            remainingErrors--; // Уменьшаем количество оставшихся ошибок после каждого обнаруженного ошибочного теста
        }

        return remainingErrors;
    }
}