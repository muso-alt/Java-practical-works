import java.util.ArrayList;
import java.util.List;

public class InformationSystem {
    public static void main(String[] args) {
        // Исходные данные
        String[] requests = {"A", "B", "C", "D", "E"};
        int[] priorities = {2, 3, 1, 4, 5};
        int[] arrivalTimes = {0, 4, 5, 6, 7};
        int[] processingTimes = {2, 3, 6, 1, 2};

        List<Request> requestList = new ArrayList<>();

        // Создание объектов запросов и добавление их в список
        for (int i = 0; i < requests.length; i++) {
            Request request = new Request(requests[i], priorities[i], arrivalTimes[i], processingTimes[i]);
            requestList.add(request);
        }

        // Сортировка запросов по времени поступления
        requestList.sort((r1, r2) -> Integer.compare(r1.getArrivalTime(), r2.getArrivalTime()));

        // Построение диаграммы поступления и обработки запросов
        System.out.println("Диаграмма поступления и обработки запросов:");
        int currentTime = 0;
        for (Request request : requestList) {
            int requestStartTime = Math.max(currentTime, request.getArrivalTime());
            int requestEndTime = requestStartTime + request.getProcessingTime();

            System.out.println(request.getName() + ": " + requestStartTime + " - " + requestEndTime);

            currentTime = requestEndTime;
        }

        // Определение среднего значения времени выполнения запросов
        int totalProcessingTime = 0;
        for (Request request : requestList) {
            totalProcessingTime += request.getProcessingTime();
        }
        double averageProcessingTime = (double) totalProcessingTime / requestList.size();

        System.out.println("\nСреднее значение времени выполнения запросов: " + averageProcessingTime);

        // Анализ результатов обслуживания запросов
        boolean timelyResponse = averageProcessingTime <= 7;
        String response = timelyResponse ? "Система удовлетворяет критерию своевременности представления запрашиваемой выходной информации."
                : "Система не удовлетворяет критерию своевременности представления запрашиваемой выходной информации.";
        System.out.println("\nРезультаты обслуживания запросов: " + response);
    }
}

class Request {
    private String name;
    private int priority;
    private int arrivalTime;
    private int processingTime;

    public Request(String name, int priority, int arrivalTime, int processingTime) {
        this.name = name;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }
}