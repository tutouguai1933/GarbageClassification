package com.djy.garbageclassification.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author djy
 * @since 2024-05-19
 */
@Getter
@Setter
@ApiModel(value = "Attempts对象", description = "")
public class Attempts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attempt_id", type = IdType.AUTO)
    private Integer attemptId;

    private Integer testId;

    private String trashType;

    private String choice;

    private Boolean isCorrect;
}
