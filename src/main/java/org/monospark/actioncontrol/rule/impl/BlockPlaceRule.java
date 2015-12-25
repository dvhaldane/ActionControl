package org.monospark.actioncontrol.rule.impl;

import org.monospark.actioncontrol.matcher.MatcherType;
import org.monospark.actioncontrol.rule.ActionRuleSimple;
import org.monospark.actioncontrol.rule.filter.ActionFilterOption;
import org.monospark.actioncontrol.rule.filter.ActionFilterTemplate;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.event.block.ChangeBlockEvent;

public final class BlockPlaceRule extends ActionRuleSimple<ChangeBlockEvent.Place> {

    public BlockPlaceRule() {
        super("placeBlock", ChangeBlockEvent.Place.class);
    }

    @Override
    protected ActionFilterTemplate createFilter() {
        return ActionFilterTemplate.builder()
                .addOption(new ActionFilterOption<BlockSnapshot, ChangeBlockEvent.Place>("blockIds",
                        MatcherType.BLOCK, e -> e.getTransactions().get(0).getFinal()))
                .build();
    }
}