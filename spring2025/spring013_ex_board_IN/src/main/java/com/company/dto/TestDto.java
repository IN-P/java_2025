package com.company.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
public class TestDto {
	private final String cmopany;
	private int year;
}
