/**
 * Simple thread that removes 1 element inside the PQEUC priority queue.
 */
public class RemovePQEUC extends Thread {

    /**
     * Image.
     */
    private Image image;

    /**
     * Height
     */
    private int height;

    /**
     * Width.
     */
    private int width;

    /**
     * Simple constructor that sets image,height and width.
     * @param image_ Image
     * @param height_ Height
     * @param width_ Width
     */
    public RemovePQEUC(Image image_,int height_,int width_){
        image = image_;
        height=height_;
        width=width_;
    }

    public void run(){
        Pixel data;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                data = image.remove(2);
                System.out.println("Thread3-PQEUC: ["+data.Red+","+data.Green
                        +","+data.Blue+"]");
            }
        }

    }
}
