package kr.nexters.eightweeks;

public interface TransactionListener {
    public final int RESULT_CODE_SUCCESS = 0;
    public final int RESULT_CODE_FAIL = -1;
    
    public void onActionDone(int resultCode, Object param, Object tag);
}
