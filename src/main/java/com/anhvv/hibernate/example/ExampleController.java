package com.anhvv.hibernate.example;

import com.anhvv.hibernate.example.inheritance.PaymentDetailEntity;
import com.anhvv.hibernate.example.inheritance.PaymentDetailRepository;
import com.anhvv.hibernate.example.inheritance.PaymentEntity;
import com.anhvv.hibernate.example.inheritance.PaymentRepository;
import com.anhvv.hibernate.example.inheritance.TaskDetailEntity;
import com.anhvv.hibernate.example.inheritance.TaskDetailRepository;
import com.anhvv.hibernate.example.inheritance.TaskEntity;
import com.anhvv.hibernate.example.inheritance.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/example/inheritance")
@AllArgsConstructor
public class ExampleController {
    private final PaymentRepository paymentRepository;
    private final TaskRepository taskRepository;
    private final PaymentDetailRepository paymentDetailRepository;
    private final TaskDetailRepository taskDetailRepository;

    @GetMapping("/payment")
    public Object getPaymentAll(){
        List<PaymentEntity> payments = paymentRepository.findAll();
        return payments;
    }

    @GetMapping("/payment-detail")
    public Object getPaymentDetailAll(){
        List<PaymentDetailEntity> paymentDetails = paymentDetailRepository.findAll();
        return paymentDetails;
    }

    @GetMapping("/task")
    public Object getTaskAll(){
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks;
    }

    @GetMapping("/task-join")
    public Object getTaskJoin(){
        List<TaskEntity> tasks = taskRepository.testQuery();
        return tasks;
    }

    @GetMapping("/task-detail")
    public Object getTaskDetailAll(){
        List<TaskDetailEntity> taskDetails = taskDetailRepository.findAll();
        return taskDetails;
    }

    @PostMapping("/task-detail/{task-id}")
    @Transactional
    public Object postTaskDetail(@PathVariable("task-id") Long taskId){
        TaskDetailEntity taskDetail = new TaskDetailEntity();
        taskDetail.setName("Task ");
//        taskDetail.setTask(taskRepository.findById(taskId).orElseGet(null));
        taskDetailRepository.save(taskDetail);
        return "Ok";
    }

    @PostMapping("/payment")
    @Transactional
    public Object postPayment(){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(1234L);
        paymentEntity.setName("Payment ");

        PaymentDetailEntity paymentDetail = new PaymentDetailEntity();
        paymentDetail.setName("Payment detail");
        paymentEntity.addPaymentDetail(paymentDetail);

        paymentRepository.save(paymentEntity);
        return "Ok";
    }

    @PostMapping("/payment-detail/{payment-id}")
    @Transactional
    public Object postPaymentDetail(@PathVariable("payment-id") Long paymentId){
       PaymentDetailEntity paymentDetail = new PaymentDetailEntity();
        paymentDetail.setName("Payment ");
        paymentDetail.setPayment(paymentRepository.findById(paymentId).orElse(null));
        paymentDetailRepository.save(paymentDetail);
        return "Ok";
    }

    @PostMapping("/payment-detail")
    @Transactional
    public Object postPaymentDetail(){
        PaymentDetailEntity paymentDetail = new PaymentDetailEntity();
        paymentDetail.setName("Payment Detail");
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setName("Payment Detail");
        paymentEntity.setAmount(12345L);
        paymentDetail.setPayment(paymentEntity);
        paymentDetailRepository.save(paymentDetail);
        return "Ok";
    }

    @PutMapping("/payment/{payment-id}/{payment-detail-id}")
    @Transactional
    public Object putPayment(@PathVariable("payment-id") Long paymentId, @PathVariable("payment-detail-id")Long paymentDetailId){
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(new PaymentEntity());
        PaymentDetailEntity paymentDetailEntity = paymentDetailRepository.findById(paymentDetailId)
                .orElse(new PaymentDetailEntity());
        paymentEntity.removePaymentDetail(paymentDetailEntity);
        paymentRepository.save(paymentEntity);
        return "Ok";
    }

    @PutMapping("/payment-remove-id/{payment-id}/{payment-detail-id}")
    @Transactional
    public Object putPaymentById(@PathVariable("payment-id") Long paymentId, @PathVariable("payment-detail-id")Long paymentDetailId){
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(new PaymentEntity());
        PaymentDetailEntity paymentDetailEntity = new PaymentDetailEntity();
        paymentDetailEntity.setId(paymentDetailId);
        paymentEntity.removePaymentDetail(paymentDetailEntity);
        PaymentDetailEntity paymentDetailEntity1 = new PaymentDetailEntity();
        paymentDetailEntity1.setName("Payment put");
        paymentEntity.addPaymentDetail(paymentDetailEntity1);
        paymentRepository.save(paymentEntity);
        return "Ok";
    }

    @DeleteMapping("/payment-id/{payment-id}")
    @Transactional
    public Object deletePaymentById(@PathVariable("payment-id") Long paymentId){
        paymentRepository.deleteById(paymentId);
        return "Ok";
    }

    @DeleteMapping("/payment/{payment-id}")
    @Transactional
    public Object deletePayment(@PathVariable("payment-id") Long paymentId){
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(new PaymentEntity());
        paymentRepository.delete(paymentEntity);
        return "Ok";
    }

    @DeleteMapping("/payment-detail-id/{payment-detail-id}")
    @Transactional
    public Object deletePaymentDetailById(@PathVariable("payment-detail-id") Long paymentDetailId){
        paymentDetailRepository.deleteById(paymentDetailId);
        return "Ok";
    }

    @DeleteMapping("/payment-detail/{payment-detail-id}")
    @Transactional
    public Object deletePaymentDetail(@PathVariable("payment-detail-id") Long paymentDetailId){
        PaymentDetailEntity paymentDetailEntity = paymentDetailRepository.findById(paymentDetailId).orElse(new PaymentDetailEntity());
        paymentDetailRepository.delete(paymentDetailEntity);
        return "Ok";
    }

}
