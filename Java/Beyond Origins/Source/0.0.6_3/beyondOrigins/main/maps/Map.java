package beyondOrigins.main.maps;

import java.awt.Graphics;

public abstract class Map {
  protected int x;
  
  protected int y;
  
  public abstract void tick();
  
  public abstract void render(Graphics paramGraphics);
}


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\maps\Map.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */