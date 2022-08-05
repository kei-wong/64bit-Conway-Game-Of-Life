import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameofLife
{
    private final long[][] NEIGHBORS = new long[][]
            {
                    {-1, 1},
                    {0, 1},
                    {1, 1},
                    {1, 0},
                    {1, -1},
                    {0, -1},
                    {-1, -1},
                    {-1, 0}
            }; // Coordinates of the (up to) 8 neighbors of any given cell
    private HashMap<LongPoint, Integer> aliveCells;

    /**
     * Constructs a Game of Life with a starting pattern.
     * @param input  The list of coordinates read from stdin.
     */
    public GameofLife(List<LongPoint> input)
    {
        aliveCells = new HashMap<>();

        for (LongPoint cell : input)
            aliveCells.put(cell, 1); // This value doesn't actually matter
    }

    /**
     * Public method to iterate through "turns" of the Game of Life.
     * @param n  How many generations to iterate.
     */
    public void iterate(int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.println("After " + (i + 1) + " Generation(s):");
            System.out.println("#Life 1.06");
            HashMap<LongPoint, Integer> nextGeneration = getNextIteration();

            for (LongPoint cell : nextGeneration.keySet())
                System.out.println(cell);
            System.out.println();
        }
    }

    /**
     * Create the next generation of living cells, given a pattern
     * of currently living cells.
     * @return A HashMap containing next generation's living cells.
     */
    private HashMap<LongPoint, Integer> getNextIteration()
    {
        HashMap<LongPoint, Integer> neighborCountMap = new HashMap<>();

        // Each neighbor of an alive cell has at least 1 alive neighbor.
        for (LongPoint cell : aliveCells.keySet())
            updateNeighborMap(cell, neighborCountMap);

        /* Iterate through map of live neighbor counts,
           delete cells that will die or stay dead */
        Iterator<Map.Entry<LongPoint, Integer>> cellItr = neighborCountMap.entrySet().iterator();
        while (cellItr.hasNext())
        {
            Map.Entry<LongPoint, Integer> cellAndNeighbors = cellItr.next();
            LongPoint cell = cellAndNeighbors.getKey();
            int liveNeighbors = cellAndNeighbors.getValue();

            if (aliveCells.containsKey(cell) && (liveNeighbors < 2 || liveNeighbors > 3))
                cellItr.remove();
            else if (!aliveCells.containsKey(cell) && liveNeighbors != 3)
                cellItr.remove();
        }

        aliveCells = neighborCountMap;
        return neighborCountMap;
    }

    /**
     * For each of a currently alive cell's valid neighbors,
     * increment their number of living neighbors by 1.
     * @param cell         A currently living cell whose neighbors will be processed.
     * @param mapToUpdate  The HashMap holding each cell's live neighbor count.
     */
    private void updateNeighborMap(LongPoint cell, HashMap<LongPoint, Integer> mapToUpdate)
    {
        long x = (long) cell.getX();
        long y = (long) cell.getY();

        for (long[] pos : NEIGHBORS)
        {
            long newX = x;
            long newY = y;

            if (isValidCoord(newX, pos[0]) && isValidCoord(newY, pos[1]))
            {
                newX += pos[0];
                newY += pos[1];

                LongPoint cellToUpdate = new LongPoint(newX, newY);
                if (mapToUpdate.containsKey(cellToUpdate))
                    mapToUpdate.put(cellToUpdate, mapToUpdate.get(cellToUpdate) + 1);
                else
                    mapToUpdate.put(cellToUpdate, 1);
            }
        }
    }

    /**
     * @param coordinate  The coordinate to check.
     * @param direction   The direction it's trying to look in.
     * @return whether the given coordinate can have a
     * valid neighboring cell in the given direction.
     */
    private boolean isValidCoord(long coordinate, long direction)
    {
        if ((direction > 0 && coordinate == Long.MAX_VALUE) || (direction < 0 && coordinate == Long.MIN_VALUE))
            return false;
        return true;
    }
}