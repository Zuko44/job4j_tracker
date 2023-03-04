package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс эмулирует работу банковского сервиса
 * при реализации активно задействован интерфейс Map
 *
 * @author Zuko44
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции HashMap, реализующей интерфейс Map с модификатором final
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает объект и добавляет его в коллекцию
     * в случае отсутствия подобного объекта
     *
     * @param user добавляемый в коллекцию объект класса User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает строку, и в случае обнаружения
     * юзера класса User по ней - удаляет его из коллекции
     *
     * @param passport строка принимаемая для поиска пользователя
     * @return вовзращает булевое значение при удалении пользователя
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод ищет пользователя, и в случае его обнаружения
     * (а также отсутствия передаваемого параметром аккаунта) -
     * добавляет новый аккаунт/счёт
     *
     * @param passport строка, паспорт пользователя, первый параметр
     * @param account  передаваемый объект-аккаунт, добавляемый в случае отсутствия подобного
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод ищет пользователя по строке, передаваемой параметром
     *
     * @param passport строка, передаваяемая для поиска пользователя
     * @return возвращает обект класса User в случае нахождения или null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(t -> t.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет аккаунт пользователя по переданным данным
     *
     * @param passport  строка, идентификатор пользователя
     * @param requisite строка, идентификатор аккаунта пользователя
     * @return возвращает счёт пользователя класса Account в случае его нахождения или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            return accounts.stream()
                    .filter(t -> t.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет списание средств с баланса одного счёта и перевод
     * их на другой счёт по переданным реквизитам/данным
     *
     * @param srcPassport   строка, паспорт отправителя
     * @param srcRequisite  строка, счёт отправителя
     * @param destPassport  строка, паспорт получателя
     * @param destRequisite строка, счёт получателя
     * @param amount        число, сумма, которую хочет отправить отправитель
     * @return возвращает булевое значение  в случае успешного/безуспешного
     * перевода средств со счёта отправителя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account firstAccount = findByRequisite(srcPassport, srcRequisite);
        Account secondAccount = findByRequisite(destPassport, destRequisite);
        if (firstAccount != null && secondAccount != null && firstAccount.getBalance() >= amount) {
            firstAccount.setBalance(firstAccount.getBalance() - amount);
            secondAccount.setBalance(secondAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод ищет счета пользователя по передаваемому в параметры обекту класса User
     *
     * @param user обект класса User, передаваемый параметром
     * @return возвращает список счетов пользователя, реализованный посредством интерфейса List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
