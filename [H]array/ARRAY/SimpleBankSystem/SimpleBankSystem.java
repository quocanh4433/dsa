public class SimpleBankSystem {
    private long[] balance;
    private int n;

    public SimpleBankSystem(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        // if(!isValid(account1) && !isValid(account2)) return false; // ❌ Không cần cả 2 tài khoản đều sai
        if (!isValid(account1) || !isValid(account2) || balance[account1 - 1] < money) { // ✅ Chỉ cần 1 trong 2 tài khoản SAI là giao dịch thất bại
            return false;
        }
        // if (balance[account1 - 1] < money) { // ⚠️ Đưa điều kiện lên cùng 1 if
        //     return false;
        // }
        balance[account1 - 1] -= money;  // ❌ Quên trừ tiền account 1
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

    public boolean isValid(int account) {
        //if(account < 0 && account > n && balance[account - 1] < 0) return false; // ❌ Không có số account nào vừa nhơ hơn 0 mà vừa lớn hơn n
        //return true;
        return account >= 1 && account <= n;
    }
    public static void main(String[] args) {
        
    }
}
