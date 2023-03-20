package com.streaming.play.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.streaming.play.domain.StreamRtmpAddress;
import com.streaming.play.service.StreamRtmpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.ruoyi.common.core.utils.PageUtils.startPage;

/**
 * @Date 2023/3/20 17:36
 * @Description 流媒体播放控制器
 * @since version-1.0
 */
@RestController
@RequestMapping("/play/")
public class PlayController extends BaseController {
	@Autowired
	private StreamRtmpAddressService rtmpAddressService;

	/**
	 * 查询视频地址列表
	 */
	@GetMapping("/list")
	public TableDataInfo list() {
		startPage();
		List<StreamRtmpAddress> list = rtmpAddressService.list();
		return getDataTable(list);
	}

	/**
	 * 导出视频地址列表
	 */
	@Log(title = "视频地址", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, StreamRtmpAddress rtmp) {
		List<StreamRtmpAddress> list = rtmpAddressService.list();
		ExcelUtil<StreamRtmpAddress> util = new ExcelUtil<StreamRtmpAddress>(StreamRtmpAddress.class);
		util.exportExcel(response, list, "视频地址数据");
	}

	/**
	 * 获取视频地址详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return success(rtmpAddressService.getById(id));
	}

	/**
	 * @Date 2023/3/20 17:55
	 * @Description 推流视频
	 * @Param [rtmp]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@GetMapping(value = "/play")
	public AjaxResult play(StreamRtmpAddress rtmp) {
		return success(rtmpAddressService.play(rtmp));
	}

	/**
	 * 新增视频地址
	 */
	@Log(title = "视频地址", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody StreamRtmpAddress rtmp) {
		return toAjax(rtmpAddressService.save(rtmp));
	}

	/**
	 * 修改视频地址
	 */
	@Log(title = "视频地址", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody StreamRtmpAddress rtmp) {
		return AjaxResult.success(rtmpAddressService.updateById(rtmp));
	}

	/**
	 * 删除视频地址
	 */
	@Log(title = "视频地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(rtmpAddressService.removeById(ids));
	}
}