package fiap.com.br.SofiaBag.utils;

public enum RepeatType {

	NEVER, ALLDAY, EVERYWEEK, EVERYMONTH, EVERYYEAR;
	
	
    public static RepeatType fromInteger(int x) {
        switch(x) {
        case 0:
            return NEVER;
        case 1:
            return ALLDAY;
        case 2:
        	return EVERYWEEK;
        case 3:
        	return EVERYMONTH;
        case 4:
        	return EVERYYEAR;
        }
        return null;
    }
    
}
