public class NiceTime {
    
    private long startTime;
    private int maxDecimalPlaces = 3;

    public NiceTime(){
        this.startTime = System.nanoTime();
    }

    /*
     * Default Value: 3
     * 
     * 
     * @return void
     */
    public void setMaxDecimalPlaces(int maxDecimalPlaces) throws IllegalArgumentException {
        if(maxDecimalPlaces < 0){
            throw new IllegalArgumentException("Decimal Places cant be Negative");
        }
        this.maxDecimalPlaces = maxDecimalPlaces;
    }

    /*
     * Resets the nanoTime
     * 
     * @return
     */
    public void resetTime(){
        this.startTime = System.nanoTime();
    }

    /*
     * Returns the elapsed Time from initializing this Object
     * or from last reset by calling 'resetTime()'
     * 
     * @return String
     */
    public String getElapsedTime(){
        //time
        String elapsed = new String(""+(System.nanoTime()-startTime));
        String[] end = {"ns","µs","ms","s"};
        int magnitude = elapsed.length()/3;
        int format = elapsed.length() % 3;

        return elapsed.substring(0, format)+"."+elapsed.substring(format, Math.min(format+Math.max(0, maxDecimalPlaces), elapsed.length()-1))+end[Math.min(end.length-1, magnitude)]+"\n";
    }


}