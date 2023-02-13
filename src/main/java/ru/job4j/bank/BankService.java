package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        boolean deleted = false;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                deleted = true;
            }
        }
        return deleted;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        User found = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                found = user;
                break;
            }
        }
        return found;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account found = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account need : accounts) {
                if (need.getRequisite().equals(requisite)) {
                    found = need;
                }
            }
        }
        return found;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account firstAccount = findByRequisite(srcPassport, srcRequisite);
        Account secondAccount = findByRequisite(destPassport, destRequisite);
        if (firstAccount != null && firstAccount.getBalance() >= amount) {
            if (findByRequisite(destPassport, destRequisite) != null) {
                double secondBalance = secondAccount.getBalance();
                secondAccount.setBalance(secondBalance + amount);
            } else {
                User dest = findByPassport(destPassport);
                users.get(dest).add(new Account(destRequisite, amount));
            }
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
