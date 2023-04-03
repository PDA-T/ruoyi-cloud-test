package com.xxl.job.service;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Bean模式
 *
 * 在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 */
@Slf4j
@Component
public class XxlJobService {
	/**
	 * @Date 2023/4/3 15:03
	 * @Description 测试
	 * @Param [param]
	 * @return com.xxl.job.core.biz.model.ReturnT<java.lang.String>
	 * @since version-1.0
	 */
	@XxlJob("demoJobHandler")
	public ReturnT<String> demoJobHandler(String param) throws Exception {
		log.info("XXL-JOB");
		return ReturnT.SUCCESS;
	}

	/**
	 * @Date 2023/4/3 15:06
	 * @Description 生命周期任务示例:任务初始化与销毁时,支持自定义
	 * @Param [param]
	 * @return com.xxl.job.core.biz.model.ReturnT<java.lang.String>
	 * @since version-1.0
	 */
	@XxlJob(value = "cycleJobHandler", init = "init", destroy = "destroy")
	public ReturnT<String> cycleJobHandler(String param) throws Exception {
		log.info("周期");
		return ReturnT.SUCCESS;
	}

	/**
	 * @Date 2023/4/3 15:32
	 * @Description 初始化
	 * @since version-1.0
	 */
	public void init() {
		log.info("初始化");
	}

	/**
	 * @Date 2023/4/3 15:33
	 * @Description 销毁
	 * @since version-1.0
	 */
	public void destroy() {
		log.info("销毁");
	}
}
