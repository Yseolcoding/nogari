package nogari.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/exceptions/manve")
    public void testController() throws Exception {
        throw new Exception("error@@@@@@@@@@@@@");
    }
    @PostMapping("/test/ntdb")
    public String postTest(@Valid @RequestBody SampleDTO ntbdDto){
        log.info(ntbdDto.toString());
        return "hi";
    }
}