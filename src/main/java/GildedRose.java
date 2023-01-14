import org.apache.commons.lang3.StringUtils;

public class GildedRose {

    public String name; // types: Normal, Aged Brie, Backstage passes to a TAFKAL80ETC concert,
                        // Sulfuras, Hand of Ragnaros
    public int quality;
    public int daysRemaining;

    public GildedRose(String name, int quality, int daysRemaining) {
        this.name = name;
        this.quality = quality;
        this.daysRemaining = daysRemaining;
    }

    public void normalTick() {
        if (quality > 0) {
            quality -= 1;
        }

        daysRemaining -= 1;

        if (daysRemaining < 0) {
            if (quality > 0) {
                quality -= 1;
            }
        }
    }

    public void brieTick(){
        if (quality < 50) {
            quality += 1;
        }

        daysRemaining -= 1;

        if (daysRemaining < 0) {
            
            if (quality < 50) {
                quality += 1;
            }
        
        }
    }

    public void backstageTick(){
        if (quality < 50) {
            quality += 1;
            if (StringUtils.equals(name, "Backstage passes to a TAFKAL80ETC concert")) {
                if (daysRemaining < 11 && quality < 50) {
                        quality += 1;
                }
                if (daysRemaining < 6 && quality < 50) {
                        quality += 1;
                }
            }
        }

        daysRemaining -= 1;

        if (daysRemaining < 0) {
            quality = quality - quality;
        }
    }

    public void ragnarosTick(){}
    
    public void conjuredTick(){
        
        
        // normal case quality down 2//
        // if days remaining 1 down 1
        // if days remai.. 0 and negative down 4
        // if days remaining 0 and quality 0 no down
        
        if(daysRemaining <= 0 ){
            quality -=4;
        }else{
            quality -=2;            
        }
        
        if(quality < 0){
            quality = 0;
        }
        daysRemaining -=1;
        
    }
    

    public void tick() {

        if(StringUtils.equals(name, "normal")){
            normalTick();
            return;
        }
        else if(StringUtils.equals(name, "Aged Brie")){
            brieTick();
            return;
        }
        else if(StringUtils.equals(name, "Sulfuras, Hand of Ragnaros")){
            ragnarosTick();
            return;
        }
        else if(StringUtils.equals(name, "Backstage passes to a TAFKAL80ETC concert")){
            backstageTick();
            return;
        }
        else if(StringUtils.equals(name, "Conjured Item")){
            conjuredTick();
            return;
        }
    }
}
