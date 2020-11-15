package app;

import model.CallBack;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CallBackController {

    private final CallBackDao dao;

    public CallBackController(CallBackDao dao) {
        this.dao = dao;
        CallBackGenerator generator = new CallBackGenerator();
        //Save some callbacks
        this.dao.saveCallBacks(generator.generateCallbacks(50));
    }

    @GetMapping("callbacks")
    public List<CallBack> getAllOrders() {
        return dao.getAllCallBacks();

    }
    @DeleteMapping("callbacks/{id}")
    public void deleteOrder(@PathVariable String id) {
        dao.deleteById(id);
    }
}
