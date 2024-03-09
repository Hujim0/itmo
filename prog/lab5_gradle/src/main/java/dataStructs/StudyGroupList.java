package dataStructs;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
public class StudyGroupList {
    List<StudyGroup> studyGroupList = new ArrayList<>();

    public StudyGroupList(StudyGroup...groupList) {
        this.studyGroupList.addAll(Arrays.stream(groupList).toList());
    }

    public StudyGroupList(Collection<StudyGroup> collection) {
        this.studyGroupList.addAll(collection);
    }
}
