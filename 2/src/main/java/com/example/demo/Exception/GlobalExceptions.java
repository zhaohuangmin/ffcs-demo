package com.example.demo.Exception;

import com.example.demo.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalExceptions extends RuntimeException {
    private RespBeanEnum respBeanEnum;
}
