package srm631.div2;

/**
 * Created by shashank on 9/6/14.
 */
public class TaroGrid {
    public int getNumber(String[] grid)
    {
        int max = 1;
        for(int col=0; col<grid.length; col++) {
            int currentStreak = 1;
            for (int row=0; row<grid.length-1; row++){
                if(grid[row].charAt(col)==grid[row+1].charAt(col)){
                    currentStreak++;
                }else{
                    if(max<currentStreak){
                        max = currentStreak;
                    }
                    currentStreak = 1;
                }
                if(row==grid.length-2 && max<currentStreak){
                    max=currentStreak;
                }
            }
        }
        return max;
    }
}
