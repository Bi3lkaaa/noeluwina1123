package xyz.siema.live.tiktoklive.helpers.variables;

import java.util.List;
import org.bukkit.Material;

public class SystemVariables {
    private String commandsControlDescription;
    private String commandsControlCommands;
    private List<String> commandsControlAllias;
    private String commandsControlUsageMessage;
    private String commandsErrorUsageMessage;
    private String hologramVictoryMessage;
    private String titleVictoryMessage;
    private String subtitleVictoryMessage;
    private Integer fadeInVictoryMessage;
    private Integer stayVictoryMessage;
    private Integer fadeOutVictoryMessage;
    private String errorBlock;
    private String hologramMessage;
    private String actionbarMessage;
    private String actionbarMessageMax;
    private Material blockHp;
    private Integer startHpBlock;
    private boolean startResetBoolean;
    private Integer startResetTime;

    public String getCommandsControlDescription() {
        return this.commandsControlDescription;
    }

    public String getCommandsControlCommands() {
        return this.commandsControlCommands;
    }

    public List<String> getCommandsControlAllias() {
        return this.commandsControlAllias;
    }

    public String getCommandsControlUsageMessage() {
        return this.commandsControlUsageMessage;
    }

    public String getCommandsErrorUsageMessage() {
        return this.commandsErrorUsageMessage;
    }

    public String getHologramVictoryMessage() {
        return this.hologramVictoryMessage;
    }

    public String getTitleVictoryMessage() {
        return this.titleVictoryMessage;
    }

    public String getSubtitleVictoryMessage() {
        return this.subtitleVictoryMessage;
    }

    public Integer getFadeInVictoryMessage() {
        return this.fadeInVictoryMessage;
    }

    public Integer getStayVictoryMessage() {
        return this.stayVictoryMessage;
    }

    public Integer getFadeOutVictoryMessage() {
        return this.fadeOutVictoryMessage;
    }

    public String getErrorBlock() {
        return this.errorBlock;
    }

    public String getHologramMessage() {
        return this.hologramMessage;
    }

    public String getActionbarMessage() {
        return this.actionbarMessage;
    }

    public String getActionbarMessageMax() {
        return this.actionbarMessageMax;
    }

    public Material getBlockHp() {
        return this.blockHp;
    }

    public Integer getStartHpBlock() {
        return this.startHpBlock;
    }

    public boolean isStartResetBoolean() {
        return this.startResetBoolean;
    }

    public Integer getStartResetTime() {
        return this.startResetTime;
    }

    public SystemVariables(String commandsControlDescription, String commandsControlCommands, List<String> commandsControlAllias, String commandsControlUsageMessage, String commandsErrorUsageMessage, String hologramVictoryMessage, String titleVictoryMessage, String subtitleVictoryMessage, Integer fadeInVictoryMessage, Integer stayVictoryMessage, Integer fadeOutVictoryMessage, String errorBlock, String hologramMessage, String actionbarMessage, String actionbarMessageMax, Material blockHp, Integer startHpBlock, boolean startResetBoolean, Integer startResetTime) {
        this.commandsControlDescription = commandsControlDescription;
        this.commandsControlCommands = commandsControlCommands;
        this.commandsControlAllias = commandsControlAllias;
        this.commandsControlUsageMessage = commandsControlUsageMessage;
        this.commandsErrorUsageMessage = commandsErrorUsageMessage;
        this.hologramVictoryMessage = hologramVictoryMessage;
        this.titleVictoryMessage = titleVictoryMessage;
        this.subtitleVictoryMessage = subtitleVictoryMessage;
        this.fadeInVictoryMessage = fadeInVictoryMessage;
        this.stayVictoryMessage = stayVictoryMessage;
        this.fadeOutVictoryMessage = fadeOutVictoryMessage;
        this.errorBlock = errorBlock;
        this.hologramMessage = hologramMessage;
        this.actionbarMessage = actionbarMessage;
        this.actionbarMessageMax = actionbarMessageMax;
        this.blockHp = blockHp;
        this.startHpBlock = startHpBlock;
        this.startResetBoolean = startResetBoolean;
        this.startResetTime = startResetTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SystemVariables)) {
            return false;
        } else {
            SystemVariables other = (SystemVariables)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isStartResetBoolean() != other.isStartResetBoolean()) {
                return false;
            } else {
                Object this$fadeInVictoryMessage = this.getFadeInVictoryMessage();
                Object other$fadeInVictoryMessage = other.getFadeInVictoryMessage();
                if (this$fadeInVictoryMessage == null) {
                    if (other$fadeInVictoryMessage != null) {
                        return false;
                    }
                } else if (!this$fadeInVictoryMessage.equals(other$fadeInVictoryMessage)) {
                    return false;
                }

                Object this$stayVictoryMessage = this.getStayVictoryMessage();
                Object other$stayVictoryMessage = other.getStayVictoryMessage();
                if (this$stayVictoryMessage == null) {
                    if (other$stayVictoryMessage != null) {
                        return false;
                    }
                } else if (!this$stayVictoryMessage.equals(other$stayVictoryMessage)) {
                    return false;
                }

                label215: {
                    Object this$fadeOutVictoryMessage = this.getFadeOutVictoryMessage();
                    Object other$fadeOutVictoryMessage = other.getFadeOutVictoryMessage();
                    if (this$fadeOutVictoryMessage == null) {
                        if (other$fadeOutVictoryMessage == null) {
                            break label215;
                        }
                    } else if (this$fadeOutVictoryMessage.equals(other$fadeOutVictoryMessage)) {
                        break label215;
                    }

                    return false;
                }

                label208: {
                    Object this$startHpBlock = this.getStartHpBlock();
                    Object other$startHpBlock = other.getStartHpBlock();
                    if (this$startHpBlock == null) {
                        if (other$startHpBlock == null) {
                            break label208;
                        }
                    } else if (this$startHpBlock.equals(other$startHpBlock)) {
                        break label208;
                    }

                    return false;
                }

                Object this$startResetTime = this.getStartResetTime();
                Object other$startResetTime = other.getStartResetTime();
                if (this$startResetTime == null) {
                    if (other$startResetTime != null) {
                        return false;
                    }
                } else if (!this$startResetTime.equals(other$startResetTime)) {
                    return false;
                }

                Object this$commandsControlDescription = this.getCommandsControlDescription();
                Object other$commandsControlDescription = other.getCommandsControlDescription();
                if (this$commandsControlDescription == null) {
                    if (other$commandsControlDescription != null) {
                        return false;
                    }
                } else if (!this$commandsControlDescription.equals(other$commandsControlDescription)) {
                    return false;
                }

                label187: {
                    Object this$commandsControlCommands = this.getCommandsControlCommands();
                    Object other$commandsControlCommands = other.getCommandsControlCommands();
                    if (this$commandsControlCommands == null) {
                        if (other$commandsControlCommands == null) {
                            break label187;
                        }
                    } else if (this$commandsControlCommands.equals(other$commandsControlCommands)) {
                        break label187;
                    }

                    return false;
                }

                Object this$commandsControlAllias = this.getCommandsControlAllias();
                Object other$commandsControlAllias = other.getCommandsControlAllias();
                if (this$commandsControlAllias == null) {
                    if (other$commandsControlAllias != null) {
                        return false;
                    }
                } else if (!this$commandsControlAllias.equals(other$commandsControlAllias)) {
                    return false;
                }

                Object this$commandsControlUsageMessage = this.getCommandsControlUsageMessage();
                Object other$commandsControlUsageMessage = other.getCommandsControlUsageMessage();
                if (this$commandsControlUsageMessage == null) {
                    if (other$commandsControlUsageMessage != null) {
                        return false;
                    }
                } else if (!this$commandsControlUsageMessage.equals(other$commandsControlUsageMessage)) {
                    return false;
                }

                label166: {
                    Object this$commandsErrorUsageMessage = this.getCommandsErrorUsageMessage();
                    Object other$commandsErrorUsageMessage = other.getCommandsErrorUsageMessage();
                    if (this$commandsErrorUsageMessage == null) {
                        if (other$commandsErrorUsageMessage == null) {
                            break label166;
                        }
                    } else if (this$commandsErrorUsageMessage.equals(other$commandsErrorUsageMessage)) {
                        break label166;
                    }

                    return false;
                }

                label159: {
                    Object this$hologramVictoryMessage = this.getHologramVictoryMessage();
                    Object other$hologramVictoryMessage = other.getHologramVictoryMessage();
                    if (this$hologramVictoryMessage == null) {
                        if (other$hologramVictoryMessage == null) {
                            break label159;
                        }
                    } else if (this$hologramVictoryMessage.equals(other$hologramVictoryMessage)) {
                        break label159;
                    }

                    return false;
                }

                label152: {
                    Object this$titleVictoryMessage = this.getTitleVictoryMessage();
                    Object other$titleVictoryMessage = other.getTitleVictoryMessage();
                    if (this$titleVictoryMessage == null) {
                        if (other$titleVictoryMessage == null) {
                            break label152;
                        }
                    } else if (this$titleVictoryMessage.equals(other$titleVictoryMessage)) {
                        break label152;
                    }

                    return false;
                }

                Object this$subtitleVictoryMessage = this.getSubtitleVictoryMessage();
                Object other$subtitleVictoryMessage = other.getSubtitleVictoryMessage();
                if (this$subtitleVictoryMessage == null) {
                    if (other$subtitleVictoryMessage != null) {
                        return false;
                    }
                } else if (!this$subtitleVictoryMessage.equals(other$subtitleVictoryMessage)) {
                    return false;
                }

                label138: {
                    Object this$errorBlock = this.getErrorBlock();
                    Object other$errorBlock = other.getErrorBlock();
                    if (this$errorBlock == null) {
                        if (other$errorBlock == null) {
                            break label138;
                        }
                    } else if (this$errorBlock.equals(other$errorBlock)) {
                        break label138;
                    }

                    return false;
                }

                Object this$hologramMessage = this.getHologramMessage();
                Object other$hologramMessage = other.getHologramMessage();
                if (this$hologramMessage == null) {
                    if (other$hologramMessage != null) {
                        return false;
                    }
                } else if (!this$hologramMessage.equals(other$hologramMessage)) {
                    return false;
                }

                label124: {
                    Object this$actionbarMessage = this.getActionbarMessage();
                    Object other$actionbarMessage = other.getActionbarMessage();
                    if (this$actionbarMessage == null) {
                        if (other$actionbarMessage == null) {
                            break label124;
                        }
                    } else if (this$actionbarMessage.equals(other$actionbarMessage)) {
                        break label124;
                    }

                    return false;
                }

                Object this$actionbarMessageMax = this.getActionbarMessageMax();
                Object other$actionbarMessageMax = other.getActionbarMessageMax();
                if (this$actionbarMessageMax == null) {
                    if (other$actionbarMessageMax != null) {
                        return false;
                    }
                } else if (!this$actionbarMessageMax.equals(other$actionbarMessageMax)) {
                    return false;
                }

                Object this$blockHp = this.getBlockHp();
                Object other$blockHp = other.getBlockHp();
                if (this$blockHp == null) {
                    if (other$blockHp != null) {
                        return false;
                    }
                } else if (!this$blockHp.equals(other$blockHp)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SystemVariables;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isStartResetBoolean() ? 79 : 97);
        Object $fadeInVictoryMessage = this.getFadeInVictoryMessage();
        result = result * 59 + ($fadeInVictoryMessage == null ? 43 : $fadeInVictoryMessage.hashCode());
        Object $stayVictoryMessage = this.getStayVictoryMessage();
        result = result * 59 + ($stayVictoryMessage == null ? 43 : $stayVictoryMessage.hashCode());
        Object $fadeOutVictoryMessage = this.getFadeOutVictoryMessage();
        result = result * 59 + ($fadeOutVictoryMessage == null ? 43 : $fadeOutVictoryMessage.hashCode());
        Object $startHpBlock = this.getStartHpBlock();
        result = result * 59 + ($startHpBlock == null ? 43 : $startHpBlock.hashCode());
        Object $startResetTime = this.getStartResetTime();
        result = result * 59 + ($startResetTime == null ? 43 : $startResetTime.hashCode());
        Object $commandsControlDescription = this.getCommandsControlDescription();
        result = result * 59 + ($commandsControlDescription == null ? 43 : $commandsControlDescription.hashCode());
        Object $commandsControlCommands = this.getCommandsControlCommands();
        result = result * 59 + ($commandsControlCommands == null ? 43 : $commandsControlCommands.hashCode());
        Object $commandsControlAllias = this.getCommandsControlAllias();
        result = result * 59 + ($commandsControlAllias == null ? 43 : $commandsControlAllias.hashCode());
        Object $commandsControlUsageMessage = this.getCommandsControlUsageMessage();
        result = result * 59 + ($commandsControlUsageMessage == null ? 43 : $commandsControlUsageMessage.hashCode());
        Object $commandsErrorUsageMessage = this.getCommandsErrorUsageMessage();
        result = result * 59 + ($commandsErrorUsageMessage == null ? 43 : $commandsErrorUsageMessage.hashCode());
        Object $hologramVictoryMessage = this.getHologramVictoryMessage();
        result = result * 59 + ($hologramVictoryMessage == null ? 43 : $hologramVictoryMessage.hashCode());
        Object $titleVictoryMessage = this.getTitleVictoryMessage();
        result = result * 59 + ($titleVictoryMessage == null ? 43 : $titleVictoryMessage.hashCode());
        Object $subtitleVictoryMessage = this.getSubtitleVictoryMessage();
        result = result * 59 + ($subtitleVictoryMessage == null ? 43 : $subtitleVictoryMessage.hashCode());
        Object $errorBlock = this.getErrorBlock();
        result = result * 59 + ($errorBlock == null ? 43 : $errorBlock.hashCode());
        Object $hologramMessage = this.getHologramMessage();
        result = result * 59 + ($hologramMessage == null ? 43 : $hologramMessage.hashCode());
        Object $actionbarMessage = this.getActionbarMessage();
        result = result * 59 + ($actionbarMessage == null ? 43 : $actionbarMessage.hashCode());
        Object $actionbarMessageMax = this.getActionbarMessageMax();
        result = result * 59 + ($actionbarMessageMax == null ? 43 : $actionbarMessageMax.hashCode());
        Object $blockHp = this.getBlockHp();
        result = result * 59 + ($blockHp == null ? 43 : $blockHp.hashCode());
        return result;
    }
}

