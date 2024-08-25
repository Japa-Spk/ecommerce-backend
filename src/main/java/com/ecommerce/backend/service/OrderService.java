package com.ecommerce.backend.service;

import com.ecommerce.backend.dtos.OrderDetailDto;
import com.ecommerce.backend.dtos.OrderDto;
import com.ecommerce.backend.model.Order;
import com.ecommerce.backend.model.OrderDetail;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.OrderRepository;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(OrderDto input) {
        //Validar Usuario
        User user = userRepository.findById(input.getUserID())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        //Crear Orden
        var order = new Order()
        .setTotalAmount(input.getTotalAmount())
        .setStatus(input.getStatus())
        .setOrderDetails(new ArrayList<>())
        .setUser(user);

        //Crear Detalles de la Orden
        for(OrderDetailDto detailRequest : OrderDto.getOrderDetails()){
            Product product = productRepository.findById(detailRequest.getProductID())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(detailRequest.getQuantity());
            orderDetail.setUnitPrice(product.getPrice());
            orderDetail.setSubtotal(detailRequest.getSubtotal());
            orderDetail.setProduct(product);
            // Agregar el detalle a la orden
            order.addOrderDetail(orderDetail);
        }

        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setOrderID(id);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
