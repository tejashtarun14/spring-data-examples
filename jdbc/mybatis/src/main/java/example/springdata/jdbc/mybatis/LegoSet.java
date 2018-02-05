/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.jdbc.mybatis;

import lombok.Data;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Id;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * A Lego Set consisting of multiple Blocks and a manual
 *
 * @author Jens Schauder
 */
@Data
public class LegoSet {

	@Id
	private Integer id;

	private String name;

	private Manual manual;

	// You can build multiple models from one LegoSet
	private final Map<String, Model> models = new HashMap<>();

	private static int toInt(Period period) {
		return (int) (period == null ? 0 : period.get(ChronoUnit.YEARS));
	}

	private static Period toPeriod(int years) {
		return Period.ofYears(years);
	}

	public void addModel(String name, String description) {

		Model model = new Model();
		model.name = name;
		model.description = description;
		models.put(name, model);
	}
}