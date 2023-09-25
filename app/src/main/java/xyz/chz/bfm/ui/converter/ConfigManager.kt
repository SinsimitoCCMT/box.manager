package xyz.chz.bfm.ui.converter

import xyz.chz.bfm.ui.converter.config.ClashData
import xyz.chz.bfm.ui.converter.config.ConfigType
import xyz.chz.bfm.ui.converter.config.ConfigUtil

object ConfigManager {

    fun importConfig(config: String): String {
        try {
            if (config.startsWith(ConfigType.VMESS.scheme)) {
                var result = config.replace(ConfigType.VMESS.scheme, "")
                result = ConfigUtil.decode(result)
                if (result.isEmpty()) {
                    return "failed decode vms"
                }
                return ClashData(result).newVmessConfig()
            } else if (config.startsWith(ConfigType.VLESS.scheme)) {
                return ClashData(config).newVlessConfig()
            } else {
                return ""
            }
        } catch (_: Exception) {
        }
        return ""
    }
}