package org.example;

import java.util.ArrayList;
import java.util.List;

public class MPolygon extends MShape {
    private List<Integer> points;

    public MPolygon() {
        points = new ArrayList<>();
    }

    public void addPoint(int x, int y) {
        points.add(x);
        points.add(y);

        var result = getPoints();
        setState(result);
    }

    @Override
    public void setState(String state) {
        super.setState(state);
        String[] tokens = state.split(",");
        points.clear();
        for (int i = 0; i < tokens.length; i += 2) {
            points.add(Integer.parseInt(tokens[i]));
            points.add(Integer.parseInt(tokens[i + 1]));
        }
    }
    public String getPoints(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.size(); i += 2) {
            sb.append(points.get(i)).append(",").append(points.get(i + 1));
            if (i < points.size() - 2) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    @Override
    public String getState() {
        return super.state;
    }
}
