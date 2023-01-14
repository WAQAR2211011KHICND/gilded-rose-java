public class GildedRose {

    public String name; // types: Normal, Aged Brie, Backstage passes to a TAFKAL80ETC concert,
                        // Sulfuras, Hand of Ragnaros
    public int quality;
    public int daysRemaining;

    private GildedRoseAbstract gildedRose;

    public GildedRose(String name, int quality, int daysRemaining) {
        this.name = name;
        this.quality = quality;
        this.daysRemaining = daysRemaining;

        switch (name) {
            case "normal":
                gildedRose = new Normal(quality, daysRemaining);
                break;
            case "Aged Brie":
                gildedRose = new Brie(quality, daysRemaining);   
                break;
            case "Sulfuras, Hand of Ragnaros":
                gildedRose = new Ragnaros(quality, daysRemaining);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                gildedRose = new Backstage(quality, daysRemaining);
                break;
            case "Conjured Item":
                gildedRose = new Conjured(quality, daysRemaining);
                break;
            default:
                break;
        }
    }
    
    public void syncProperties(){
        quality = gildedRose.quality;
        daysRemaining = gildedRose.daysRemaining;
    }

    public void tick() {
        gildedRose.tick();
        syncProperties();
        return ;
    }
}


abstract class GildedRoseAbstract{

    public int quality;
    public int daysRemaining;

    public void tick(){};

    public GildedRoseAbstract(int quality, int daysRemaining){
        this.quality = quality;
        this.daysRemaining = daysRemaining;
    }
}

class Normal extends GildedRoseAbstract {

    public Normal(int quality, int daysRemaining) {
        super(quality, daysRemaining);
    }

    @Override
    public void tick() {
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

}

class Ragnaros extends GildedRoseAbstract{
    public Ragnaros(int quality, int daysRemaining){
        super(quality, daysRemaining);
    }
}

class Backstage extends GildedRoseAbstract{
    public Backstage(int quality, int daysRemaining){
        super(quality, daysRemaining);
    }

    @Override
    public void tick(){
        if (quality < 50) {
            quality += 1;
                if (daysRemaining < 11 && quality < 50) {
                        quality += 1;
                }
                if (daysRemaining < 6 && quality < 50) {
                        quality += 1;
                }
        }

        daysRemaining -= 1;

        if (daysRemaining < 0) {
            quality = quality - quality;
        }
    }
}

class Conjured extends GildedRoseAbstract{
    public Conjured(int quality, int daysRemaining){
        super(quality, daysRemaining);
    }
    @Override
    public void tick() {
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
}

class Brie extends GildedRoseAbstract{
    public Brie(int quality, int daysRemaining){
        super(quality, daysRemaining);
    }    

    @Override
    public void tick(){
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
}