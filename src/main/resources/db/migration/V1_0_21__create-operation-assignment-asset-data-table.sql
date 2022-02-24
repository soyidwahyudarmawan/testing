CREATE TABLE IF NOT EXISTS operation_assignment_asset_data (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  assignment_id BIGINT NOT NULL,
  asset_brand_checked BOOLEAN DEFAULT FALSE,
  asset_model_checked BOOLEAN DEFAULT FALSE,
  asset_variant_checked BOOLEAN DEFAULT FALSE,
  asset_year_made_checked BOOLEAN DEFAULT FALSE,
  license_number_checked BOOLEAN DEFAULT FALSE,
  noka_nosin_checked BOOLEAN DEFAULT FALSE,
  color_checked BOOLEAN DEFAULT FALSE,
  tax_notice_checked BOOLEAN DEFAULT FALSE,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_operation_assignment_asset_data_operation_assignment_assignment_id FOREIGN KEY (assignment_id) REFERENCES operation_assignment (id)
);
