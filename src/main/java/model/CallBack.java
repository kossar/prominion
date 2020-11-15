package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CallBack {


    private String GUID;
    private String LastResult = "ADDED";
    private String OrigCallerNbr;
    private String last;
    private String lastresult = "ADDED";
    private String next;
    private String queuename;
    private String start;


}
