package nogari.system.ntbd.domain.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("BoardReqDTO")
public class BoardReqDTO {

    @NotNull(message = "필수값")
    String ntbdCd;              /* 게시글 코드 */
    String fileCd;               /* 파일 코드 */
    String ntbdDiv;             /* 게시글 구분 */
    String topYn;               /* 상단 게시 여부 */
    String postInDate;          /* 게시 시작일 */
    String postOutDate;         /* 게시 종료일 */
    String postNm;              /* 게시글 제목 */
    String postCont;            /* 게시글 내용 */
    String userId;              /* 유저 아이디 */
}