import java.util.ArrayList;

public class CharacterData {

private ArrayList<SegmentData> segmentDatas;

public CharacterData(){
segmentDatas = new ArrayList<SegmentData>();
}

public ArrayList<SegmentData> getCharacterData(){
return segmentDatas;
}

public void addSegmentData(SegmentData s){
segmentDatas.add(s);
}

/*
This class should also have a method that can write self to json
(basically an array of that segmentdata array)
*/
}