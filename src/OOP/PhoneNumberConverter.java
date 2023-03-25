package OOP;

public class PhoneNumberConverter {
    public static void main(String[] args) {
        var number = convert("“+79175655655");
        System.out.println(number);
    }

    public static String convert(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\D", ""); // Убираем все нецифровые символы из номера

        if (phoneNumber.startsWith("8") && phoneNumber.length() == 11) { // Если номер начинается с 8 и имеет 11 цифр, значит это российский номер
            phoneNumber = "+7" + phoneNumber.substring(1); // Заменяем первую цифру 8 на +7
        } else if (phoneNumber.startsWith("+")) { // Если номер начинается с +, значит он уже в нужном формате
            phoneNumber = phoneNumber.substring(1); // Убираем первый символ +
        }

        if (phoneNumber.length() == 12) { // Если номер имеет длину 12 цифр, значит он в формате +<Код страны><Номер 10 цифр>
            String countryCode = phoneNumber.substring(0, 2); // Получаем код страны
            String number = phoneNumber.substring(2); // Получаем номер
            return "+" + countryCode + "-" + number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
        } else { // Иначе номер должен быть в формате 8<Номер 10 цифр>
            String number = phoneNumber.substring(1); // Получаем номер
            return "+7-" + number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
        }
    }
}