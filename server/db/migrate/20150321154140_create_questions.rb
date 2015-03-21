class CreateQuestions < ActiveRecord::Migration
  def change
    create_table :questions do |t|
      t.text :options
      t.text :question
      t.text :geo
      t.belongs_to :user_id, index: true

      t.timestamps
    end
  end
end
