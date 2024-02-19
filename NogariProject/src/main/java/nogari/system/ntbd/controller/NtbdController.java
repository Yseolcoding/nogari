package nogari.system.ntbd.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.ntbd.domain.dto.BoardReqDTO;
import nogari.system.ntbd.domain.dto.BoardRespDTO;
import nogari.system.ntbd.service.NtbdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 *     게시판 컨트롤러
 * </pre>
 */
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class NtbdController {

    private final NtbdService ntbdService;

    /**
     * <pre>
     *     게시글 목록 조회 API
     * </pre>
     * @return
     */
    @GetMapping
    public ResponseEntity<List<BoardRespDTO>> boardList(){
        List<BoardRespDTO> boardList = ntbdService.findBoards();
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    /**
     * <pre>
     *      게시글 내용 조회 API
     * </pre>
     * @param ntbdCd (게시글 코드)
     * @return
     */
    @GetMapping("/{ntbdCd}")
    public ResponseEntity<List<BoardRespDTO>> boardDetails(@PathVariable String ntbdCd){
        List<BoardRespDTO> board = ntbdService.findBoard(ntbdCd);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    /**
     * <pre>
     *     게시글 등록 API
     * </pre>
     * @param boardReqDTO   등록할 게시글 정보
     * @return
     */
    @PostMapping("")
    public ResponseEntity<String> boardAdd(@RequestBody BoardReqDTO boardReqDTO){
        String result = ntbdService.createBoard(boardReqDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * <pre>
     *     게시글 수정 API
     * </pre>
     * @param boardReqDTO   수정할 게시글 정보
     * @return
     */
    @PutMapping("/{ntbdCd}")
    public ResponseEntity<String> boardModify(@RequestBody BoardReqDTO boardReqDTO) {
        String result = ntbdService.editBoard(boardReqDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * <pre>
     *      게시글 단건 삭제 API
     * </pre>
     * @param ntbdCd
     * @return
     */
    @DeleteMapping("/{ntbdCd}")
    public ResponseEntity<String> boardRemove(@PathVariable String ntbdCd){
        String result = ntbdService.deleteBoard(ntbdCd);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * <pre>
     *     게시글 다건 삭제 API
     * </pre>
     * @param ntbdCds   (ex : [ "2", "3"])
     * @return
     */
    @PostMapping("/delete-multi")
    public ResponseEntity<String> boardsRemove(@RequestBody List<String> ntbdCds){
        String result = ntbdService.deleteBoards(ntbdCds);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
